package com.alibiner.mappers.service.appointment;

import com.alibiner.dtos.response.animal.service.AnimalResponseDto;
import com.alibiner.dtos.response.appointment.service.AppointmentDetailResponseDto;
import com.alibiner.dtos.response.appointment.service.AppointmentResponseDto;
import com.alibiner.dtos.response.appointment.service.GetAllAppointmentResponseDto;
import com.alibiner.dtos.response.user.UserResponseDto;
import com.alibiner.entities.Appointment;
import com.alibiner.mappers.service.animal.AnimalMapper;
import com.alibiner.mappers.service.customer.UserMapper;

public class AppointmentMapper {
    public static AppointmentResponseDto toAppointmentResponseDto(Appointment entity) {
        AppointmentResponseDto dto = new AppointmentResponseDto();
        dto.setId(entity.getId());
        dto.setStartDate(entity.getStartDate());
        dto.setFinishDate(entity.getFinishDate());
        return dto;
    }

    public static AppointmentDetailResponseDto toAppointmentDetailResponseDto(Appointment entity) {
        UserResponseDto owner = UserMapper.toUserResponseDto(entity.getAnimal().getUser());
        UserResponseDto doctor = UserMapper.toUserResponseDto(entity.getDoctor());
        AnimalResponseDto animal = AnimalMapper.toAnimalResponseDto(entity.getAnimal());

        return new AppointmentDetailResponseDto(
                entity.getId(),
                doctor,
                animal,
                owner,
                entity.getStartDate(),
                entity.getFinishDate(),
                entity.getCompanionName(),
                entity.getStatus(),
                entity.getCreatedDate(),
                entity.getUpdatedDate()
        );

    }

    public static GetAllAppointmentResponseDto toGetAllAppointmentResponseDto(Appointment entity) {
        return new GetAllAppointmentResponseDto(
                entity.getId(),
                entity.getDoctor().getName(),
                entity.getAnimal().getUser().getName(),
                entity.getAnimal().getName(),
                entity.getStartDate(),
                entity.getFinishDate(),
                entity.getStatus(),
                entity.getCompanionName()
        );
    }
}
