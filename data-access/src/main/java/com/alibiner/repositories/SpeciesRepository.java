package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, UUID>, JpaSpecificationExecutor<Species> {
    boolean existsByNameAndIsDeleteFalse(String name);

    Optional<Species> findByIdAndIsDeleteFalse(UUID id);

}
