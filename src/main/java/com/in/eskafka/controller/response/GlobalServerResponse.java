package com.in.eskafka.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GlobalServerResponse<T> {
    @JsonProperty("resultInfo")
    private ResultDataDto resultDataDto;

    @JsonProperty("data")
    @JsonInclude
    private T data;

    public GlobalServerResponse() {
    }

    public GlobalServerResponse(ResultDataDto resultDataDto, T data) {
        this.data = data;
        this.resultDataDto = resultDataDto;
    }
}