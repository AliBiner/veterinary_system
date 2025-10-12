package com.alibiner.services.species;

import java.util.*;
import com.alibiner.config.modelMapper.IModelMapperService;
import com.alibiner.dtos.request.species.service.SpeciesRequestDto;
import com.alibiner.dtos.response.species.SpeciesResponseDto;
import com.alibiner.entities.Species;
import com.alibiner.exceptions.AlreadyExistException;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.interfaces.species.ISpeciesService;
import com.alibiner.repositories.SpeciesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SpeciesService implements ISpeciesService {
    private final SpeciesRepository speciesRepository;
    private final IModelMapperService modelMapperService;

    public SpeciesService(SpeciesRepository speciesRepository, IModelMapperService modelMapperService) {
        this.speciesRepository = speciesRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public SpeciesResponseDto create(SpeciesRequestDto dto) {
        if (speciesRepository.existsByNameAndIsDeleteFalse(dto.getName()))
            throw new AlreadyExistException("Species name already exists");

        Species species = modelMapperService.forRequest().map(dto, Species.class);

        speciesRepository.save(species);
        return modelMapperService.forResponse().map(species, SpeciesResponseDto.class);
    }

    @Override
    public SpeciesResponseDto update(SpeciesRequestDto dto) {
        Optional<Species> species = speciesRepository.findByIdAndIsDeleteFalse(dto.getId());
        if (species.isEmpty())
            throw new NotFoundException("Species not found");
        if (speciesRepository.existsByNameAndIsDeleteFalse(dto.getName()))
            throw new AlreadyExistException("Species name already exists");

        species.get().setName(dto.getName());
        speciesRepository.save(species.get());
        return modelMapperService.forResponse().map(species.get(), SpeciesResponseDto.class);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public SpeciesResponseDto getById(Long aLong) {
        return null;
    }

    @Override
    public Page<SpeciesResponseDto> getAll(Pageable pageable) {
        return null;
    }
}
