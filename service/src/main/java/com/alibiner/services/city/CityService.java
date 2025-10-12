package com.alibiner.services.city;


import java.util.*;
import com.alibiner.config.modelMapper.IModelMapperService;
import com.alibiner.dtos.request.city.service.CityRequestDto;
import com.alibiner.dtos.response.city.CityResponseDto;
import com.alibiner.entities.City;
import com.alibiner.exceptions.AlreadyExistException;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.interfaces.city.ICityService;
import com.alibiner.repositories.CityRepository;
import com.alibiner.specifications.city.CitySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CityService implements ICityService {

    private final CityRepository cityRepository;
    private final IModelMapperService modelMapper;

    public CityService(CityRepository cityRepository, IModelMapperService modelMapper) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CityResponseDto create(CityRequestDto dto) {
        if (cityRepository.existsByNameAndIsDeleteFalse(dto.getName())) {
            throw new AlreadyExistException("City name already exists");
        }

        City city = modelMapper.forRequest().map(dto, City.class);
        cityRepository.save(city);
        return modelMapper.forResponse().map(city, CityResponseDto.class);
    }

    @Override
    public CityResponseDto update(CityRequestDto dto) {

        if (!cityRepository.existsByIdAndIsDeleteFalse(dto.getId()))
            throw new NotFoundException("City not found");
        if (cityRepository.existsByNameAndIsDeleteFalse(dto.getName()))
            throw new AlreadyExistException("City name already exists");

        City city = modelMapper.forRequest().map(dto, City.class);
        cityRepository.save(city);
        return modelMapper.forResponse().map(city, CityResponseDto.class);
    }

    @Override
    public void delete(UUID id) {
        Optional<City> city = cityRepository.findByIdAndIsDeleteFalse(id);
        if (city.isEmpty())
            throw new NotFoundException("City not found");
        city.get().setDelete(true);
        cityRepository.save(city.get());
    }

    @Override
    public CityResponseDto getById(UUID id) {
        Optional<City> city = cityRepository.findByIdAndIsDeleteFalse(id);
        if (city.isEmpty())
            throw new NotFoundException("City Not Found");
        return modelMapper.forResponse().map(city.get(), CityResponseDto.class);
    }

    @Override
    public Page<CityResponseDto> getAll(Pageable pageable, CitySpecification specification) {
        Page<City> cities = cityRepository.findAll(specification, pageable);
        return cities.map(city -> modelMapper.forResponse().map(city, CityResponseDto.class));
    }
}
