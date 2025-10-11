package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
    boolean existsByNameIgnoreCaseAndIsDeleteFalse(String name);

    boolean existsByIdAndIsDeleteFalse(Long id);

    Optional<Color> findByIdAndIsDeleteFalse(Long id);
}
