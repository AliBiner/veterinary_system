package com.alibiner.dtos.request.color.service;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ColorRequestDto implements BaseRequestDto {
    private UUID id;
    private String name;
}
