package com.in.eskafka.dataaccess.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.in.eskafka.application.repository.OrganizationEsRepository;
import com.in.eskafka.constants.ConstantHelper;
import com.in.eskafka.entity.es.OrganizationEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationEsRepositoryImpl implements OrganizationEsRepository {
    private final RestHighLevelClient client;
    private final ObjectMapper objectMapper;

    @Override
    public List<OrganizationEntity> getOrganizationListEs() throws IOException {
        SortBuilder sortBuilder = SortBuilders.fieldSort("organization_id");
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchQuery("organization_is_deleted", false));
        SearchRequest searchRequest = new SearchRequest(ConstantHelper.ES_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.sort(sortBuilder);
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(100);
        searchRequest.source(searchSourceBuilder);
        List<OrganizationEntity> organizationData = new ArrayList<>();

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        for (SearchHit hit : hits) {
            OrganizationEntity organizationEntityObject = objectMapper.readValue(hit.getSourceAsString(), OrganizationEntity.class);
            organizationEntityObject.setOrganizationId(hit.getId());
            organizationData.add(organizationEntityObject);
        }
        return organizationData;
    }
}
