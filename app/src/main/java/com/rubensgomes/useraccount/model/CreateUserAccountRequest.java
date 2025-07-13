package com.rubensgomes.useraccount.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateUserAccountRequest(@Email String email, @NotBlank String password) {}
