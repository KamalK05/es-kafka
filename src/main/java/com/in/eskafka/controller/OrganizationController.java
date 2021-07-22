package com.in.eskafka.controller;

import com.in.eskafka.application.OrganizationApplication;
import com.in.eskafka.controller.request.AddOrganizationRequest;
import com.in.eskafka.controller.request.UpdateOrganizationRequest;
import com.in.eskafka.controller.response.GlobalServerResponse;
import com.in.eskafka.util.ResponseUtil;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationController {
    private final OrganizationApplication organizationApplication;

    /**
     * Add entry for organization.
     */
    @PostMapping(value = "/v1/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GlobalServerResponse> addOrganization(
            @RequestBody @Valid AddOrganizationRequest addOrganizationRequest) {
        organizationApplication.addOrganization(addOrganizationRequest);
        return ResponseUtil.getSuccessResponse(null);
    }

    /**
     * Get entry for organization.
     */
    @GetMapping(value = "/v1/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GlobalServerResponse> getOrganizationList() {
        return ResponseUtil.getSuccessResponse(organizationApplication.getOrganizationList());
    }

    /**
     * delete entry for organization.
     */
    @DeleteMapping(value = "/v1/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GlobalServerResponse> deleteOrganization(@RequestParam String organizationId) {
        organizationApplication.deleteOrganization(Long.parseLong(organizationId));
        return ResponseUtil.getSuccessResponse(null);
    }

    /**
     * Update status for organization.
     */
    @PatchMapping(value = "/v1/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GlobalServerResponse> updateOrganization(
            @RequestBody @Valid UpdateOrganizationRequest updateOrganizationRequest) {
        organizationApplication.updateOrganization(updateOrganizationRequest);
        return ResponseUtil.getSuccessResponse(null);
    }
}
