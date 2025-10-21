package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, UUID>, JpaSpecificationExecutor<Vaccine> {
}
