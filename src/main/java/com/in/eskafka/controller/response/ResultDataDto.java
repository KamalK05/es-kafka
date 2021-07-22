package com.in.eskafka.controller.response;

import lombok.Data;

@Data
public class ResultDataDto {
    private String code;
    private String message;
    private String codeId;

    public ResultDataDto(String codeId, String code, String message) {
        this.code = code;
        this.codeId = codeId;
        this.message = message;
    }
}