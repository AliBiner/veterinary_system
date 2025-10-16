package com.alibiner.dtos.request.customer.service;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerRequestDto extends BaseRequestDto {
    private UUID id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private UUID cityId;
}
