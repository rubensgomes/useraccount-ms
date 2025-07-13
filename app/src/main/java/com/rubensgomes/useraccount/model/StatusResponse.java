package com.rubensgomes.useraccount.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record StatusResponse(@NotNull Status status, @NotBlank String msg) {}
