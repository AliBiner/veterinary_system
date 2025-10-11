package com.alibiner.interfaces.color;

import com.alibiner.dtos.request.color.service.ColorRequestDto;
import com.alibiner.dtos.response.color.ColorResponseDto;
import com.alibiner.interfaces.ICRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IColorService extends ICRUDService<ColorRequestDto, ColorResponseDto, Long> {
    Page<ColorResponseDto> getByName(String name, Pageable pageable);
}
