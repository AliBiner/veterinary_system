package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, UUID>, JpaSpecificationExecutor<Examination> {
}
