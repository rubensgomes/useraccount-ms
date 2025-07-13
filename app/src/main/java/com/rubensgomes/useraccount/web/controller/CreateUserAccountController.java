package com.rubensgomes.useraccount.web.controller;

import com.rubensgomes.useraccount.model.CreateUserAccountRequest;
import com.rubensgomes.useraccount.model.Status;
import com.rubensgomes.useraccount.model.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A front-end implementation for a RESTful end-point to create a user account.
 *
 * @author Rubens Gomes
 */
@Slf4j
@Validated
@RestController("createUserAccountController")
public class CreateUserAccountController {

  // OpenAPI information
  private static final String TAG_NAME = "createUserAccount";
  private static final String DESCRIPTION = "Creates and stores user account in the server.";
  private static final String OPERATION_ID = "createUserAccount";
  private static final String SUMMARY = "Creates a user account.";

  private static final String CREATE_USER_ACCOUNT_OPERATION = "/api/create-user-account";

  @Tag(name = TAG_NAME, description = SUMMARY)
  @PostMapping(
      path = {CREATE_USER_ACCOUNT_OPERATION},
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @Operation(
      summary = SUMMARY,
      operationId = OPERATION_ID,
      description = DESCRIPTION)
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully created user account"),
          @ApiResponse(responseCode = "400", description = "Invalid createUserAccount requestd"),
          @ApiResponse(responseCode = "500", description = "Internal error response")
  })
  public ResponseEntity<StatusResponse> createUserAccount(
      @Valid @RequestBody final CreateUserAccountRequest request) {
    log.info("Creating user account: {}", request);
    StatusResponse statusResponse = new StatusResponse(Status.FAILURE, "missing code");
    return ResponseEntity.ok(statusResponse);
  }

}
