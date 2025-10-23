package com.alibiner.dtos.request.user.customer.controller;

import java.util.*;
import com.alibiner.errorMessages.ErrorMessages;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


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

    public CustomerUpdateRequestDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getCityId() {
        return cityId;
    }

    public void setCityId(UUID cityId) {
        this.cityId = cityId;
    }
}
