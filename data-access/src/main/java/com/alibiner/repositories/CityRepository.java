package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<City, UUID>, JpaSpecificationExecutor<City> {

    boolean existsByNameAndIsDeleteFalse(String name);

    boolean existsByIdAndIsDeleteFalse(UUID id);

    Optional<City> findByIdAndIsDeleteFalse(UUID id);

}
