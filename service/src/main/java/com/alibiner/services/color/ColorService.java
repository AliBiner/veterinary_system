package com.alibiner.services.color;

import java.util.*;
import com.alibiner.config.modelMapper.IModelMapperService;
import com.alibiner.dtos.request.color.service.ColorRequestDto;
import com.alibiner.dtos.response.color.ColorResponseDto;
import com.alibiner.entities.Color;
import com.alibiner.exceptions.AlreadyExistException;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.interfaces.color.IColorService;
import com.alibiner.repositories.ColorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ColorService implements IColorService {
    private final IModelMapperService modelMapperService;
    private final ColorRepository colorRepository;

    public ColorService(IModelMapperService modelMapperService, ColorRepository colorRepository) {
        this.modelMapperService = modelMapperService;
        this.colorRepository = colorRepository;
    }

    @Override
    public ColorResponseDto create(ColorRequestDto dto) {
        if (colorRepository.existsByNameIgnoreCaseAndIsDeleteFalse(dto.getName()))
            throw new AlreadyExistException("Color name already exists");

        Color mappedCity = modelMapperService.forRequest().map(dto, Color.class);
        colorRepository.save(mappedCity);
        return modelMapperService.forResponse().map(mappedCity, ColorResponseDto.class);
    }

    @Override
    public ColorResponseDto update(ColorRequestDto requestDto) {
        if (!colorRepository.existsByIdAndIsDeleteFalse(requestDto.getId()))
            throw new NotFoundException("Color not found");
        if (colorRepository.existsByNameIgnoreCaseAndIsDeleteFalse(requestDto.getName()))
            throw new AlreadyExistException("Color name already exists");
        Color color = modelMapperService.forRequest().map(requestDto, Color.class);
        colorRepository.save(color);
        return modelMapperService.forResponse().map(color, ColorResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Color> color = colorRepository.findByIdAndIsDeleteFalse(id);
        if (color.isEmpty())
            throw new NotFoundException("Color not found");

        color.get().setDelete(true);
        colorRepository.save(color.get());
    }

    @Override
    public ColorResponseDto getById(Long aLong) {
        return null;
    }

    @Override
    public Page<ColorResponseDto> getAll(Pageable pageable) {
        return null;
    }
}
