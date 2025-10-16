package com.alibiner.veterinary_management_system.mappers.controller.customer;


import com.alibiner.dtos.request.customer.controller.CustomerCreateRequestDto;
import com.alibiner.dtos.request.customer.controller.CustomerUpdateRequestDto;
import com.alibiner.dtos.request.customer.service.CustomerRequestDto;

public class CustomerMapper {

    public static CustomerRequestDto toCustomerRequestDto(CustomerCreateRequestDto dto) {
        return new CustomerRequestDto(
                null,
                dto.getName(),
                dto.getPhone(),
                dto.getMail(),
                dto.getAddress(),
                dto.getCityID()
        );
    }

    public static CustomerRequestDto toCustomerRequestDto(CustomerUpdateRequestDto dto) {
        return new CustomerRequestDto(
                dto.getId(),
                dto.getName(),
                dto.getPhone(),
                dto.getMail(),
                dto.getAddress(),
                dto.getCityId()
        );
    }


}
