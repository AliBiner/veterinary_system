package com.alibiner.enums;


import jakarta.persistence.AttributeConverter;

public class AppointmentStatusConverter implements AttributeConverter<AppointmentStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AppointmentStatus attribute) {
        return attribute.getCode();
    }

    @Override
    public AppointmentStatus convertToEntityAttribute(Integer dbData) {
        return AppointmentStatus.getValue(dbData);
    }
}
