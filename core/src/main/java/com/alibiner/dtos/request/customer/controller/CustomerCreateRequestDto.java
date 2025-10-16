package com.alibiner.dtos.request.customer.controller;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerCreateRequestDto {

    @NotNull(message = "customer name can not be null")
    @NotBlank(message = "customer name can not be blank")
    private String name;

    @NotNull(message = "customer phone can not be null")
    @NotBlank(message = "customer phone can not be blank")
    @Size(min = 10, max = 10, message = "customer phone must be 10 character")
    private String phone;

    @NotNull(message = "customer mail can not be null")
    @Email(message = "Invalid email format")
    private String mail;

    @NotNull(message = "customer address can not be null")
    private String address;

    @JsonProperty(value = "cityId", required = true)
    private UUID cityID;
}
