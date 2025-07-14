package com.rubensgomes.useraccount.service;

import com.rubensgomes.useraccount.model.Status;
import com.rubensgomes.useraccount.model.StatusResponse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * A facade service class to isolate front-end (web layer) from the domain (business layer). This
 * facade delegates to the right domain layer responsible to create the user sacaouunt.
 *
 * @author Rubens Gomes
 */
@Validated
@Service
public class CreateUserAccountService {
  public StatusResponse createUserAccount(
      @Email final String email, @NotBlank final String password) {
    // TODO: coding to do
    var response = new StatusResponse(Status.SUCCESS, "user account {} created");
    return response;
  }
}
