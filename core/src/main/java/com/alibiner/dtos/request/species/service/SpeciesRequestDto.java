package com.alibiner.dtos.request.species.service;

import com.alibiner.dtos.request.BaseRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpeciesRequestDto extends BaseRequestDto {
    private long id;
    private String name;
}
