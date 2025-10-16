package com.alibiner.specifications.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchCriteria {
    private String name;
    private String phone;
    private String mail;
}
