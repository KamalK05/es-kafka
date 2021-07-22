package com.in.eskafka.entity.es;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationEntity {
    @JsonProperty("organization_id")
    private String organizationId;
    @JsonProperty("organization_name")
    private String organizationName;
    @JsonProperty("organization_status")
    private int organizationStatus;
    @JsonProperty("organization_type")
    private int organizationType;
    @JsonProperty("organization_established_date")
    private String organizationEstablishedDate;
    @JsonProperty("organization_is_deleted")
    private boolean organizationIsDeleted;


}
