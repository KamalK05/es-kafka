package com.in.eskafka.controller.request;

import com.in.eskafka.config.annotations.Status;
import com.in.eskafka.config.annotations.Type;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrganizationRequest {
    @NotNull(message = "name must not null")
    private String organizationId;
    @Status
    private String status;
}
