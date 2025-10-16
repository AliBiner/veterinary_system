package com.alibiner.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserType attribute) {
        return attribute.getCode();
    }

    @Override
    public UserType convertToEntityAttribute(Integer dbData) {
        return UserType.getValue(dbData);
    }
}
