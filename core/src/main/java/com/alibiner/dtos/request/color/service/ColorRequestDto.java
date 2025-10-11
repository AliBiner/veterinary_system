package com.alibiner.dtos.request.color.service;

import com.alibiner.dtos.request.BaseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ColorRequestDto extends BaseRequestDto {
    private Long id;
    private String name;
}
