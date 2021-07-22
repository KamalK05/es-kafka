package com.in.eskafka.application.service.organization.update;

import com.in.eskafka.entity.rds.OrganizationMaster;

public interface UpdateOrganizationService {
    /**
     * Update status of organization.
     */
    OrganizationMaster update(OrganizationMaster organizationMaster);
}
