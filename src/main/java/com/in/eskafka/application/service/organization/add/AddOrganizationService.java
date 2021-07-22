package com.in.eskafka.application.service.organization.add;

import com.in.eskafka.entity.rds.OrganizationMaster;

public interface AddOrganizationService {
    /**
     * Add organization.
     */
    OrganizationMaster add(OrganizationMaster organizationMaster);
}
