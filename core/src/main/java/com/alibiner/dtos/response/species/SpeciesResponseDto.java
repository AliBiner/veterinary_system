package com.alibiner.dtos.response.species;

import com.alibiner.dtos.response.BaseResponseDto;
import lombok.Data;

@Data
public class SpeciesResponseDto extends BaseResponseDto {
    private long id;
    private String name;
}
