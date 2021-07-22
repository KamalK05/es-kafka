package com.in.eskafka.application.service.organization.update.impl;

import com.in.eskafka.application.repository.PersistOrganizationRepo;
import com.in.eskafka.application.service.organization.update.UpdateOrganizationService;
import com.in.eskafka.entity.rds.OrganizationMaster;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UpdateOrganizationServiceImpl implements UpdateOrganizationService {
    private final PersistOrganizationRepo persistOrganizationRepo;

    @Override
    public OrganizationMaster update(OrganizationMaster organizationMaster) {
        return persistOrganizationRepo.update(organizationMaster);
    }
}
