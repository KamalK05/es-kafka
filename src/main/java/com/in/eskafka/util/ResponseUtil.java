package com.in.eskafka.util;

import com.in.eskafka.constants.EsKafkaResultCode;
import com.in.eskafka.controller.response.GlobalServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<GlobalServerResponse> getSuccessResponse(T data) {
        return ResponseEntity.status(HttpStatus.OK).body(genericSuccessResponse(data));
    }

    private static <T> GlobalServerResponse<T> genericSuccessResponse(T data) {
        return new GlobalServerResponse(EsKafkaResultCode.ES_KAFKA_API_SUCCESS, data);
    }
}