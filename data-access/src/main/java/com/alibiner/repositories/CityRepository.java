package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

//    boolean existsByName(String name);

    Page<City> findAllByIsDeleteFalse(Pageable pageable);

    Optional<City> findByIdAndIsDeleteFalse(Long id);

    boolean existsByIdAndIsDeleteFalse(Long id);

    boolean existsByNameIgnoreCaseAndIsDeleteFalse(String name);

    Page<City> findByNameContainsAndIsDeleteFalse(String name, Pageable pageable);
}
