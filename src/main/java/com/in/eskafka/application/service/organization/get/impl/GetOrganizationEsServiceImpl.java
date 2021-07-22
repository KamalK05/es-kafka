package com.in.eskafka.application.service.organization.get.impl;

import com.in.eskafka.application.repository.OrganizationEsRepository;
import com.in.eskafka.application.service.organization.get.GetOrganizationEsService;
import com.in.eskafka.entity.es.OrganizationEntity;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GetOrganizationEsServiceImpl implements GetOrganizationEsService {
    private final OrganizationEsRepository organizationEsRepository;

    public List<OrganizationEntity> getOrganizationListEs() throws IOException {
        return organizationEsRepository.getOrganizationListEs();
    }
}
