package com.in.eskafka.application.repository;

import com.in.eskafka.entity.rds.OrganizationMaster;
import java.util.List;

public interface GetOrganizationRepo {
    /**
     * Get organization list from database.
     */
    List<OrganizationMaster> getOrganizationList();

    /**
     * Get organization based on unique id.
     */
    OrganizationMaster getOrganization(Long uniqueId);
}
