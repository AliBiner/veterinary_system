package com.alibiner.dtos.request.user;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.enums.UserType;


public class UserRequestDto implements BaseRequestDto {
    private UUID id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private UUID cityId;
    private final UserType userType;

    public UserRequestDto(UUID id, String name, String phone, String mail, String address, UUID cityId, UserType userType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.cityId = cityId;
        this.userType = userType;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getAddress() {
        return address;
    }

    public UUID getCityId() {
        return cityId;
    }

    public UserType getUserType() {
        return userType;
    }
}
