package com.in.eskafka.application.repository;

import com.in.eskafka.entity.es.OrganizationEntity;
import java.io.IOException;
import java.util.List;

public interface OrganizationEsRepository {
    /**
     * Get organization list from elastic search.
     */
    List<OrganizationEntity> getOrganizationListEs() throws IOException;
}
