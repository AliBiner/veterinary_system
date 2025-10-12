package com.alibiner.interfaces.species;

import com.alibiner.dtos.request.species.service.SpeciesRequestDto;
import com.alibiner.dtos.response.species.SpeciesResponseDto;
import com.alibiner.interfaces.ICRUDService;

public interface ISpeciesService extends ICRUDService<SpeciesRequestDto, SpeciesResponseDto, Long> {
}
