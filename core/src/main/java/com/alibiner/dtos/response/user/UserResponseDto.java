package com.alibiner.dtos.response.user;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;
import com.alibiner.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto implements BaseResponseDto {
    private UUID id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
    private UserType userType;
}
