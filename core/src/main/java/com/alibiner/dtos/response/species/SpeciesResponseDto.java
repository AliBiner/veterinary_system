package com.alibiner.dtos.response.species;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;
import lombok.Data;

@Data
public class SpeciesResponseDto implements BaseResponseDto {
    private UUID id;
    private String name;
}
