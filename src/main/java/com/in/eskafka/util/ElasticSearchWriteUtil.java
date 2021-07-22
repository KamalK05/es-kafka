package com.in.eskafka.util;

import com.in.eskafka.constants.ConstantHelper;
import com.in.eskafka.constants.ESOrganizationDoc;
import com.in.eskafka.exception.EsWriteException;
import com.in.eskafka.stream.entities.OrganizationEvent;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ElasticSearchWriteUtil implements ESOrganizationDoc {
    private final RestHighLevelClient client;

    private static final String _DOC = "_doc";

    public Boolean writeDataToElasticSearch(OrganizationEvent organizationEvent) {
        try {
            XContentBuilder builder = jsonBuilder().startObject()
                    .field(ORG_RESOURCE_TYPE, ORG_RESOURCE_VALUE)
                    .field(ORG_ID, organizationEvent.getUniqueId())
                    .field(ORG_NAME, organizationEvent.getName())
                    .field(ORG_TYPE, organizationEvent.getType())
                    .field(ORG_STATUS, organizationEvent.getStatus())
                    .field(ORG_ESTABLISHED_DATE, organizationEvent.getEstablishedDate())
                    .field(ORG_IS_DELETED, organizationEvent.isDeleted())
                    .endObject();

            IndexRequest indexRequest = new IndexRequest(ConstantHelper.ES_INDEX, _DOC,
                    String.valueOf(organizationEvent.getUniqueId())).source(builder);

            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            log.info("Added Data : v1: {}", indexResponse);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            throw new EsWriteException();
        }
    }
}
