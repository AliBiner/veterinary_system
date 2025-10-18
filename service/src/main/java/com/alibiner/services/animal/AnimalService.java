package com.alibiner.services.animal;

import java.util.*;
import com.alibiner.dtos.request.animal.service.AnimalRequestDto;
import com.alibiner.dtos.request.user.UserRequestDto;
import com.alibiner.dtos.response.animal.service.AnimalResponseDto;
import com.alibiner.dtos.response.user.UserResponseDto;
import com.alibiner.entities.Animal;
import com.alibiner.entities.Color;
import com.alibiner.entities.Species;
import com.alibiner.entities.User;
import com.alibiner.enums.UserType;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.interfaces.animal.IAnimalService;
import com.alibiner.interfaces.color.IColorService;
import com.alibiner.interfaces.species.ISpeciesService;
import com.alibiner.interfaces.user.IUserService;
import com.alibiner.mappers.service.animal.AnimalMapper;
import com.alibiner.mappers.service.color.ColorMapper;
import com.alibiner.mappers.service.customer.UserMapper;
import com.alibiner.mappers.service.species.SpeciesMapper;
import com.alibiner.repositories.AnimalRepository;
import com.alibiner.specifications.animal.AnimalSpecification;
import com.alibiner.specifications.user.UserSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class AnimalService implements IAnimalService {
    private final AnimalRepository animalRepository;
    private final ISpeciesService speciesService;
    private final IColorService colorService;
    private final IUserService<UserRequestDto, UserResponseDto, UserSpecification> userService;
    private final UserType canOwnAnAnimal = UserType.CUSTOMER;

    public AnimalService(AnimalRepository animalRepository, ISpeciesService speciesService, IColorService colorService, IUserService<UserRequestDto, UserResponseDto, UserSpecification> userService) {
        this.animalRepository = animalRepository;
        this.speciesService = speciesService;
        this.colorService = colorService;
        this.userService = userService;
    }

    @Override
    public AnimalResponseDto create(@NonNull AnimalRequestDto dto) {
        User user = findUserByIdAndCanOwnAnAnimal(dto.getUserId());

        Species species = findSpeciesById(dto.getSpeciesId());

        Color color = findColorById(dto.getColorId());

        Animal animal = AnimalMapper.toAnimal(dto, species, color, user);

        animalRepository.save(animal);
        return AnimalMapper.toAnimalResponseDto(animal);
    }

    @Override
    public AnimalResponseDto update(AnimalRequestDto dto) {
        Animal animal = findAnimalById(dto.getId());

        User user = findUserByIdAndCanOwnAnAnimal(dto.getUserId());

        Species species = findSpeciesById(dto.getSpeciesId());

        Color color = findColorById(dto.getColorId());

        animal.setUser(user);
        animal.setSpecies(species);
        animal.setColor(color);
        animal.setGender(dto.getGender());
        animal.setBreed(dto.getBreed());
        animal.setBirthOfDate(dto.getBirthOfDate());

        animalRepository.save(animal);
        return AnimalMapper.toAnimalResponseDto(animal);
    }

    @Override
    public void delete(UUID id) {
        Animal animal = findAnimalById(id);
        animal.setDelete(true);
        animalRepository.save(animal);
    }

    @Override
    public AnimalResponseDto getById(UUID id) {
        Animal animal = findAnimalById(id);
        return AnimalMapper.toAnimalResponseDto(animal);
    }

    @Override
    public Page<AnimalResponseDto> getAll(Pageable pageable, AnimalSpecification specification) {
        Page<Animal> all = animalRepository.findAll(specification, pageable);
        return all.map(AnimalMapper::toAnimalResponseDto);
    }

    private User findUserByIdAndCanOwnAnAnimal(UUID id) throws NotFoundException {
        if (id == null)
            throw new IllegalArgumentException("user id can not be null");
        if (userService.getById(id, canOwnAnAnimal) instanceof UserResponseDto userResult) {
            return UserMapper.toUser(userResult);
        } else
            throw new NotFoundException(canOwnAnAnimal.name() + " not found");
    }

    private Species findSpeciesById(UUID id) {
        if (id == null)
            throw new IllegalArgumentException("species id can not be null");
        return SpeciesMapper.toSpecies(speciesService.getById(id));
    }

    private Color findColorById(UUID id) {
        if (id == null)
            throw new IllegalArgumentException("color id can not be null");

        return ColorMapper.toColor(colorService.getById(id));
    }

    private Animal findAnimalById(UUID id) {
        if (id == null)
            throw new IllegalArgumentException("animal id can not be null");

        Optional<Animal> animal = animalRepository.findByIdAndIsDeleteFalse(id);

        if (animal.isEmpty())
            throw new NotFoundException("animal not found");

        return animal.get();
    }
}
