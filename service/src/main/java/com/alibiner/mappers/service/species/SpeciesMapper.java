package com.alibiner.mappers.service.species;

import com.alibiner.dtos.response.species.SpeciesResponseDto;
import com.alibiner.entities.Species;

public class SpeciesMapper {
    public static Species toSpecies(SpeciesResponseDto dto) {
        Species species = new Species();
        species.setId(dto.getId());
        species.setName(dto.getName());
        return species;
    }
}
