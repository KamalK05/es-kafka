package com.in.eskafka.controller;

import com.in.eskafka.application.EsApplication;
import com.in.eskafka.controller.response.GlobalServerResponse;
import com.in.eskafka.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EsController {
    private final EsApplication esApplication;

    /**
     * Get organization list from elastic search.
     */
    @GetMapping(value = "/v1/es/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GlobalServerResponse> getOrganizationListEs() {

        return ResponseUtil.getSuccessResponse(esApplication.getOrganizationListEs());
    }
}
