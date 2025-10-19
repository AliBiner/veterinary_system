package com.alibiner.mappers.service.appointment;

import com.alibiner.dtos.response.appointment.service.AppointmentResponseDto;
import com.alibiner.entities.Appointment;

public class AppointmentMapper {
    public static AppointmentResponseDto toAppointmentResponseDto(Appointment entity) {
        AppointmentResponseDto dto = new AppointmentResponseDto();
        dto.setId(entity.getId());
        dto.setStartDate(entity.getStartDate());
        dto.setFinishDate(entity.getFinishDate());
        return dto;
    }
}
