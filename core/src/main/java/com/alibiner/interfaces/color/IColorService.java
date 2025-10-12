package com.alibiner.interfaces.color;

import com.alibiner.dtos.request.color.service.ColorRequestDto;
import com.alibiner.dtos.response.color.ColorResponseDto;
import com.alibiner.interfaces.ICRUDService;
import com.alibiner.specifications.color.ColorSpecification;

public interface IColorService extends ICRUDService<ColorRequestDto, ColorResponseDto, ColorSpecification> {
}
