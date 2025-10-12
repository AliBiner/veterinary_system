package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, UUID>, JpaSpecificationExecutor<Color> {
    boolean existsByNameAndIsDeleteFalse(String name);

    boolean existsByIdAndIsDeleteFalse(UUID id);

    Optional<Color> findByIdAndIsDeleteFalse(UUID id);
}
