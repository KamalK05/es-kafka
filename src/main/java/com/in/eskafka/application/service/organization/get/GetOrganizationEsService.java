package com.in.eskafka.application.service.organization.get;

import com.in.eskafka.entity.es.OrganizationEntity;
import java.io.IOException;
import java.util.List;

public interface GetOrganizationEsService {
    /**
     * Get organization list from elastic search.
     */
    List<OrganizationEntity> getOrganizationListEs() throws IOException;
}
