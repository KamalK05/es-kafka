package com.in.eskafka.application.service.organization.add.impl;

import com.in.eskafka.application.repository.PersistOrganizationRepo;
import com.in.eskafka.application.service.organization.add.AddOrganizationService;
import com.in.eskafka.entity.rds.OrganizationMaster;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddOrganizationServiceImpl implements AddOrganizationService {
    private final PersistOrganizationRepo persistOrganizationRepo;

    @Override
    public OrganizationMaster add(OrganizationMaster organizationMaster) {
        return persistOrganizationRepo.add(organizationMaster);
    }
}
