package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
    boolean existsByNameIgnoreCaseAndIsDeleteFalse(String name);

    boolean existsByIdAndIsDeleteFalse(Long id);

    Optional<Color> findByIdAndIsDeleteFalse(Long id);

    Page<Color> findAllByIsDeleteFalse(Pageable pageable);

    Page<Color> findByNameContainsIgnoreCaseAndIsDeleteFalse(String name, Pageable pageable);
}
