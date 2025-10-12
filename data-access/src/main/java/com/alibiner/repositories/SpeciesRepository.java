package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.Species;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {
    boolean existsByNameAndIsDeleteFalse(String name);

    Optional<Species> findByIdAndIsDeleteFalse(Long id);

    Page<Species> findByIsDeleteFalse(Pageable pageable);

    Page<Species> findByNameContainsIgnoreCaseAndIsDeleteFalse(String name, Pageable pageable);

}
