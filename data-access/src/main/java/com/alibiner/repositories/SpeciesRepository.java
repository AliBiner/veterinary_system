package com.alibiner.repositories;

import com.alibiner.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {
    boolean existsByNameAndIsDeleteFalse(String name);
}
