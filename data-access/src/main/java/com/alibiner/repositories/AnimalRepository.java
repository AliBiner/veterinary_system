package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, UUID>, JpaSpecificationExecutor<Animal> {

    Optional<Animal> findByIdAndIsDeleteFalse(UUID id);
}
