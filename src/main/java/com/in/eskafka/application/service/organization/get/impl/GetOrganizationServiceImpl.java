package com.in.eskafka.application.service.organization.get.impl;

import com.in.eskafka.application.repository.GetOrganizationRepo;
import com.in.eskafka.application.service.organization.get.GetOrganizationService;
import com.in.eskafka.entity.rds.OrganizationMaster;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GetOrganizationServiceImpl implements GetOrganizationService {
    private final GetOrganizationRepo getOrganizationRepo;

    @Override
    public List<OrganizationMaster> getOrganizationList() {
        return getOrganizationRepo.getOrganizationList();
    }

    @Override
    public OrganizationMaster getOrganization(Long uniqueId) {
        return getOrganizationRepo.getOrganization(uniqueId);
    }
}
