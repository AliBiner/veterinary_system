package com.alibiner.dtos.request.species.service;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class SpeciesRequestDto implements BaseRequestDto {
    private UUID id;
    private String name;
}
