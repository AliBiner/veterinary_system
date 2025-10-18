package com.alibiner.mappers.service.animal;


import com.alibiner.dtos.request.animal.service.AnimalRequestDto;
import com.alibiner.dtos.response.animal.service.AnimalResponseDto;
import com.alibiner.entities.Animal;
import com.alibiner.entities.Color;
import com.alibiner.entities.Species;
import com.alibiner.entities.User;
import org.springframework.lang.NonNull;


public class AnimalMapper {
    public static Animal toAnimal(@NonNull AnimalRequestDto requestDto,
                                  @NonNull Species species,
                                  @NonNull Color color,
                                  @NonNull User user) {


        Animal animal = new Animal();
        if (requestDto.getId() == null) {
            animal.setSpecies(species);
            animal.setColor(color);
            animal.setUser(user);
            animal.setName(requestDto.getName());
            animal.setBreed(requestDto.getBreed());
            animal.setGender(requestDto.getGender());
            animal.setBirthOfDate(requestDto.getBirthOfDate());
        }
        return animal;
    }


    public static AnimalResponseDto toAnimalResponseDto(Animal animal) {
        return new AnimalResponseDto(
                animal.getId(),
                animal.getName(),
                animal.getSpecies().getName(),
                animal.getBreed(),
                animal.getColor().getName(),
                animal.getUser().getId(),
                animal.getUser().getName(),
                animal.getGender(),
                animal.getBirthOfDate());
    }
}
