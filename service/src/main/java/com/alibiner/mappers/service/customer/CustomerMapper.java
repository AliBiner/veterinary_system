package com.alibiner.mappers.service.customer;


import com.alibiner.dtos.request.customer.service.CustomerRequestDto;
import com.alibiner.dtos.response.customer.CustomerResponseDto;
import com.alibiner.entities.User;

public class CustomerMapper {

    public static CustomerResponseDto toCustomerResponseDto(User user) {
        return new CustomerResponseDto(
                user.getId(),
                user.getName(),
                user.getPhone(),
                user.getMail(),
                user.getAddress(),
                user.getCity().getName(),
                user.getUserType()
        );
    }

    public static User toUser(CustomerRequestDto dto) {
        return new User(
                dto.getName(),
                dto.getPhone(),
                dto.getMail(),
                dto.getAddress()
        );
    }

}
