package com.alibiner.mappers.service.color;

import com.alibiner.dtos.response.color.ColorResponseDto;
import com.alibiner.entities.Color;

public class ColorMapper {
    public static Color toColor(ColorResponseDto dto) {
        Color color = new Color();
        color.setId(dto.getId());
        color.setName(dto.getName());
        return color;
    }
}
