package com.alibiner.veterinary_management_system.mappers.controller.customer;


import com.alibiner.dtos.request.customer.controller.CustomerCreateRequestDto;
import com.alibiner.dtos.request.customer.service.CustomerRequestDto;

public class CustomerMapper {

    public CustomerRequestDto toCustomerRequestDto(CustomerCreateRequestDto dto) {
        return new CustomerRequestDto(
                null,
                dto.getName(),
                dto.getPhone(),
                dto.getMail(),
                dto.getAddress(),
                dto.getCityID()
        );
    }
}
