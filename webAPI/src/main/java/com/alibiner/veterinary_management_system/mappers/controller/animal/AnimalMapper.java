package com.alibiner.veterinary_management_system.mappers.controller.animal;


import com.alibiner.dtos.request.animal.controller.AnimalCreateRequestDto;
import com.alibiner.dtos.request.animal.controller.AnimalUpdateRequestDto;
import com.alibiner.dtos.request.animal.service.AnimalRequestDto;
import com.alibiner.enums.Gender;

public class AnimalMapper {
    public static AnimalRequestDto toAnimalRequestDto(AnimalCreateRequestDto dto) {
        AnimalRequestDto animalRequestDto = new AnimalRequestDto();
        animalRequestDto.setId(null);
        animalRequestDto.setName(dto.getName());
        animalRequestDto.setBreed(dto.getBreed());
        animalRequestDto.setGender(Gender.valueOf(dto.getGender()));
        animalRequestDto.setBirthOfDate(dto.getBirthOfDate());
        animalRequestDto.setColorId(dto.getColorId());
        animalRequestDto.setSpeciesId(dto.getSpeciesId());
        animalRequestDto.setUserId(dto.getOwnerId());
        return animalRequestDto;
    }

    public static AnimalRequestDto toAnimalRequestDto(AnimalUpdateRequestDto dto) {
        AnimalRequestDto animalRequestDto = new AnimalRequestDto();
        animalRequestDto.setId(dto.getId());
        animalRequestDto.setName(dto.getName());
        animalRequestDto.setBreed(dto.getBreed());
        animalRequestDto.setGender(Gender.valueOf(dto.getGender()));
        animalRequestDto.setBirthOfDate(dto.getBirthOfDate());
        animalRequestDto.setColorId(dto.getColorId());
        animalRequestDto.setSpeciesId(dto.getSpeciesId());
        animalRequestDto.setUserId(dto.getOwnerId());
        return animalRequestDto;
    }
}
