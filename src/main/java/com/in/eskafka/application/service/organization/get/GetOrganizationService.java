package com.in.eskafka.application.service.organization.get;

import com.in.eskafka.entity.rds.OrganizationMaster;
import java.util.List;

public interface GetOrganizationService {
    /**
     * Get organization list from database.
     */
    List<OrganizationMaster> getOrganizationList();

    /**
     * Get organization based on unique id.
     */
    OrganizationMaster getOrganization(Long uniqueId);
}
