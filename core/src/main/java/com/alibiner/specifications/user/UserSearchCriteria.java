package com.alibiner.specifications.user;

import java.util.*;
import com.alibiner.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
