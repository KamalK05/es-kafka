package com.in.eskafka.controller.response;

import com.in.eskafka.entity.es.OrganizationEntity;
import com.in.eskafka.entity.rds.OrganizationMaster;
import com.in.eskafka.util.EnumReadUtil;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOrganizationListResponse {
    List<OrganizationResponse> OrganizationResponseList;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrganizationResponse {
        private Long organizationId;
        private String organizationName;
        private String organizationStatus;
        private String organizationType;
        private String organizationEstablishedDate;
        private Boolean organizationIsDeleted;
    }

    public static GetOrganizationListResponse buildGetOrganizationListResponseES
            (List<OrganizationEntity> organizationEntityList) {
        List<OrganizationResponse> OrganizationResponseList = new ArrayList<>();
        organizationEntityList.forEach(organizationEntity -> {
            OrganizationResponse response = new OrganizationResponse();
            response.setOrganizationId(Long.parseLong(organizationEntity.getOrganizationId()));
            response.setOrganizationName(organizationEntity.getOrganizationName());
            response.setOrganizationType(organizationEntity.getOrganizationType() != 0 ?
                    (String) EnumReadUtil.OrganizationType().get(organizationEntity.getOrganizationType()) : null);
            response.setOrganizationStatus(organizationEntity.getOrganizationStatus() != 0 ?
                    (String) EnumReadUtil.OrganizationStatus().get(organizationEntity.getOrganizationStatus()) : null);
            response.setOrganizationEstablishedDate(organizationEntity.getOrganizationEstablishedDate());
            response.setOrganizationIsDeleted(organizationEntity.isOrganizationIsDeleted());
            OrganizationResponseList.add(response);
        });
        return GetOrganizationListResponse.builder().OrganizationResponseList(OrganizationResponseList).build();
    }

    public static GetOrganizationListResponse buildGetOrganizationListResponseDB
            (List<OrganizationMaster> organizationMasterList) {
        List<OrganizationResponse> OrganizationResponseList = new ArrayList<>();
        organizationMasterList.forEach(organizationMaster -> {
            OrganizationResponse response = new OrganizationResponse();
            response.setOrganizationId(organizationMaster.getUniqueId());
            response.setOrganizationName(organizationMaster.getName());
            response.setOrganizationType(organizationMaster.getType().name());
            response.setOrganizationStatus(organizationMaster.getStatus().name());
            response.setOrganizationEstablishedDate(organizationMaster.getEstablishedDate().toString());
            response.setOrganizationIsDeleted(organizationMaster.getIsDeleted());
            OrganizationResponseList.add(response);
        });
        return GetOrganizationListResponse.builder().OrganizationResponseList(OrganizationResponseList).build();
    }
}
