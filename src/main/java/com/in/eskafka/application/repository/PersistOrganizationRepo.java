package com.in.eskafka.application.repository;

import com.in.eskafka.entity.rds.OrganizationMaster;

public interface PersistOrganizationRepo {
    /**
     * Add organization.
     */
    OrganizationMaster add(OrganizationMaster organizationMaster);

    /**
     * Update status of organization.
     */
    OrganizationMaster update(OrganizationMaster organizationMaster);
}
