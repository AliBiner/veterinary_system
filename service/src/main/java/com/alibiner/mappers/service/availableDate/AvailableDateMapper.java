package com.alibiner.mappers.service.availableDate;


import com.alibiner.dtos.response.availableDate.AvailableDateResponseDto;
import com.alibiner.entities.AvailableDate;

public class AvailableDateMapper {
    public static AvailableDateResponseDto toAvailableDateResponseDto(AvailableDate entity) {
        AvailableDateResponseDto dto = new AvailableDateResponseDto();
        dto.setId(entity.getId());
        dto.setDoctorName(entity.getUser().getName());
        dto.setDoctorId(entity.getUser().getId());
        dto.setAvailableDate(entity.getAvailableDate());
        return dto;
    }
}
