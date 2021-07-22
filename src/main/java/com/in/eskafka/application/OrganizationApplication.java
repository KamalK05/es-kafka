package com.in.eskafka.application;

import com.in.eskafka.application.service.organization.add.AddOrganizationService;
import com.in.eskafka.application.service.organization.get.GetOrganizationService;
import com.in.eskafka.application.service.organization.update.UpdateOrganizationService;
import com.in.eskafka.controller.request.AddOrganizationRequest;
import com.in.eskafka.controller.request.UpdateOrganizationRequest;
import com.in.eskafka.controller.response.GetOrganizationListResponse;
import com.in.eskafka.entity.rds.OrganizationMaster;
import com.in.eskafka.entity.enums.OrgStatus;
import com.in.eskafka.entity.enums.OrgType;
import com.in.eskafka.exception.AddDbFailureException;
import com.in.eskafka.exception.GetDbFailureException;
import com.in.eskafka.exception.GetRecordFailureException;
import com.in.eskafka.exception.UpdateRecordFailureException;
import com.in.eskafka.stream.entities.OrganizationEvent;
import com.in.eskafka.stream.producer.KafkaProducer;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationApplication {
    private final KafkaProducer kafkaProducer;
    private final AddOrganizationService addOrganizationService;
    private final GetOrganizationService getOrganizationService;
    private final UpdateOrganizationService updateOrganizationService;

    public void addOrganization(AddOrganizationRequest addOrganizationRequest) {
        // add data in database
        OrganizationMaster responseEntity = addOrganizationService
                .add(buildOrganizationMaster(addOrganizationRequest));
        // validate added entity
        if (Objects.isNull(responseEntity)) {
            // failure message
            throw new AddDbFailureException();
        }
        // publish kafka message
        produceKafkaMessage(responseEntity);
    }

    /**
     * build database entity.
     */
    private OrganizationMaster buildOrganizationMaster(AddOrganizationRequest addOrganizationRequest) {
        long random_int = (long) Math.floor(Math.random() * (999999 - 1 + 1) + 1);
        return OrganizationMaster.builder().uniqueId(random_int).name(addOrganizationRequest.getName())
                .type(OrgType.valueOf(addOrganizationRequest.getType()))
                .establishedDate(LocalDateTime.ofInstant(Instant.ofEpochMilli(addOrganizationRequest.getEstablishedDate()), ZoneId.systemDefault()))
                .status(OrgStatus.PENDING)
                .isDeleted(false).build();
    }


    /**
     * Produce kafka event.
     */
    private void produceKafkaMessage(OrganizationMaster organizationMaster) {
        kafkaProducer.sendOrganizationInformation(buildOrganizationEvent(organizationMaster));
    }

    /**
     * Build event request.
     */
    private OrganizationEvent buildOrganizationEvent(OrganizationMaster organizationMaster) {
        OrganizationEvent organizationEvent = new OrganizationEvent();
        organizationEvent.setUniqueId(organizationMaster.getUniqueId());
        organizationEvent.setName(organizationMaster.getName());
        organizationEvent.setType(organizationMaster.getType().getCode());
        organizationEvent.setEstablishedDate(organizationMaster.getEstablishedDate().toString());
        organizationEvent.setStatus(organizationMaster.getStatus().getCode());
        organizationEvent.setDeleted(organizationMaster.getIsDeleted());
        return organizationEvent;
    }

    public GetOrganizationListResponse getOrganizationList() {
        List<OrganizationMaster> organizationMasterList = getOrganizationService.getOrganizationList();
        if (Objects.isNull(organizationMasterList)) {
            throw new GetDbFailureException();
        }
        return GetOrganizationListResponse.buildGetOrganizationListResponseDB(organizationMasterList);
    }

    public void deleteOrganization(Long organizationId) {
        OrganizationMaster organizationMaster = getOrganizationService.getOrganization(organizationId);
        if (Objects.isNull(organizationMaster)) {
            throw new GetRecordFailureException();
        }
        organizationMaster.setIsDeleted(true);
        OrganizationMaster organizationMasterUpdate = updateOrganizationService.update(organizationMaster);
        if (Objects.isNull(organizationMasterUpdate)) {
            throw new UpdateRecordFailureException();
        }
        // update kafka
        produceKafkaMessage(organizationMasterUpdate);
    }

    public void updateOrganization(UpdateOrganizationRequest updateOrganizationRequest) {
        OrganizationMaster organizationMaster = getOrganizationService.getOrganization(Long.parseLong(updateOrganizationRequest.getOrganizationId()));
        if (Objects.isNull(organizationMaster)) {
            throw new GetRecordFailureException();
        }
        organizationMaster.setStatus(OrgStatus.valueOf(updateOrganizationRequest.getStatus()));

        OrganizationMaster organizationMasterUpdate = updateOrganizationService.update(organizationMaster);
        if (Objects.isNull(organizationMasterUpdate)) {
            throw new UpdateRecordFailureException();
        }
        // update kafka
        produceKafkaMessage(organizationMasterUpdate);
    }
}
