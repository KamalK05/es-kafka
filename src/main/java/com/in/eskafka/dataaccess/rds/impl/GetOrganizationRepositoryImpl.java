package com.in.eskafka.dataaccess.rds.impl;

import com.in.eskafka.application.repository.GetOrganizationRepo;
import com.in.eskafka.dataaccess.rds.OrganizationRepository;
import com.in.eskafka.entity.rds.OrganizationMaster;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GetOrganizationRepositoryImpl implements GetOrganizationRepo {
    private final OrganizationRepository organizationRepository;

    @Override
    public List<OrganizationMaster> getOrganizationList() {
        return organizationRepository.findByIsDeleted(false);
    }

    @Override
    public OrganizationMaster getOrganization(Long uniqueId) {
        return organizationRepository.findByUniqueIdAndIsDeleted(uniqueId, false);
    }
}
