package com.alibiner.dtos.request.species.service;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpeciesRequestDto implements BaseRequestDto {
    private UUID id;
    private String name;
}
