package com.alibiner.interfaces.species;

import com.alibiner.dtos.request.species.service.SpeciesRequestDto;
import com.alibiner.dtos.response.species.SpeciesResponseDto;
import com.alibiner.interfaces.ICRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISpeciesService extends ICRUDService<SpeciesRequestDto, SpeciesResponseDto, Long> {

    Page<SpeciesResponseDto> getByName(String name, Pageable pageable);
}
