package com.alibiner.dtos.request.user;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDto implements BaseRequestDto {
    private UUID id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private UUID cityId;
    private final UserType userType;
}
