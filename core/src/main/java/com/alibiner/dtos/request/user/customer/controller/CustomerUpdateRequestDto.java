package com.alibiner.dtos.request.user.customer.controller;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerUpdateRequestDto {
    @NotNull(message = "customer id can not be null")
    @JsonProperty(value = "id", required = true)
    private UUID id;

    @NotNull(message = "customer name can not be null")
    @NotBlank(message = "customer name can not be blank")
    private String name;

    @NotNull(message = "customer phone can not be null")
    @NotNull(message = "customer phone can not be blank")
    private String phone;

    @NotNull(message = "customer mail can not be null")
    @NotBlank(message = "customer mail can not be blank")
    private String mail;

    @NotNull(message = "customer address can not be null")
    private String address;

    @NotNull(message = "customer city can not be null")
    @JsonProperty(required = true, value = "cityId")
    private UUID cityId;
}
