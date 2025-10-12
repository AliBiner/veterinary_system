package com.alibiner.interfaces.species;

import com.alibiner.dtos.request.species.service.SpeciesRequestDto;
import com.alibiner.dtos.response.species.SpeciesResponseDto;
import com.alibiner.interfaces.ICRUDService;
import com.alibiner.specifications.species.SpeciesSpecification;

public interface ISpeciesService extends ICRUDService<SpeciesRequestDto, SpeciesResponseDto, SpeciesSpecification> {
}
