package com.alibiner.specifications.user;

import java.util.*;
import com.alibiner.enums.UserType;
import org.springframework.lang.NonNull;


public class UserSearchCriteria {
    private UUID id;
    private String name;
    private String phone;
    private String mail;
    private UserType userType;

    public UserSearchCriteria(String phone, String mail, @NonNull UserType userType) {
        this(null, null, phone, mail, userType);
    }

    public UserSearchCriteria(String name, String phone, String mail, @NonNull UserType userType) {
        this(null, name, phone, mail, userType);
    }

    public UserSearchCriteria(UUID id, String name, String phone, String mail, UserType userType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.userType = userType;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
