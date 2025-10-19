package com.alibiner.dtos.request.user.customer.controller;

import java.util.*;
import com.alibiner.errorMessages.ErrorMessages;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerUpdateRequestDto {
    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @JsonProperty(value = "id", required = true)
    private UUID id;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.ValidationMessages.NOT_BLANK)
    private String name;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.ValidationMessages.NOT_BLANK)
    @Size(min = 10, max = 10, message = ErrorMessages.ValidationMessages.INVALID_PHONE_FORMAT)
    private String phone;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @Email(message = ErrorMessages.ValidationMessages.INVALID_EMAIL_FORMAT)
    private String mail;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private String address;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @JsonProperty(required = true, value = "cityId")
    private UUID cityId;
}
