package com.in.eskafka.dataaccess.rds.impl;

import com.in.eskafka.application.repository.PersistOrganizationRepo;
import com.in.eskafka.dataaccess.rds.OrganizationRepository;
import com.in.eskafka.entity.rds.OrganizationMaster;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersistOrganizationRepositoryImpl implements PersistOrganizationRepo {
    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationMaster add(OrganizationMaster organizationMaster) {
        return organizationRepository.save(organizationMaster);
    }

    @Override
    public OrganizationMaster update(OrganizationMaster organizationMaster) {
        return organizationRepository.saveAndFlush(organizationMaster);
    }
}
