package com.in.eskafka.controller.request;

import com.in.eskafka.config.annotations.Type;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrganizationRequest {
    @NotNull(message = "name must not null")
    private String name;
    @Type
    private String type;
    @NotNull(message = "establishedDate must not null")
    private Long establishedDate;
}
