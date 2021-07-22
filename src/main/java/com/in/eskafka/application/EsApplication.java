package com.in.eskafka.application;

import com.in.eskafka.application.service.organization.get.GetOrganizationEsService;
import com.in.eskafka.controller.response.GetOrganizationListResponse;
import com.in.eskafka.entity.es.OrganizationEntity;
import com.in.eskafka.exception.EsReadException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EsApplication {
    private final GetOrganizationEsService getOrganizationEsService;

    public GetOrganizationListResponse getOrganizationListEs() {
        try {
            List<OrganizationEntity> organizationEntityList = getOrganizationEsService.getOrganizationListEs();
            if (Objects.isNull(organizationEntityList)) {
                throw new EsReadException();
            }
            return GetOrganizationListResponse.buildGetOrganizationListResponseES(organizationEntityList);
        } catch (IOException e) {
            log.error("IO Exception in elastic search: {}", e.getMessage(), e);
            return null;
        }
    }
}
