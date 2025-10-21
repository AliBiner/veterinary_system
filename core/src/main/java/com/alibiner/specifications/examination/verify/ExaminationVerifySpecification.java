package com.alibiner.specifications.examination.verify;


import java.util.*;
import com.alibiner.entities.Examination;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

public class ExaminationVerifySpecification implements Specification<Examination> {
    private final ExaminationVerifyCriteria criteria;

    public ExaminationVerifySpecification(@NonNull ExaminationVerifyCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Examination> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (root.get("appointment") != null)
            predicates.add(criteriaBuilder.equal(root.join("appointment").join("animal").get("id"), criteria.getAnimalId()));
        predicates.add(criteriaBuilder.equal(root.join("vaccine").get("id"), criteria.getVaccineId()));
        predicates.add(criteriaBuilder.isNotNull(root.get("vaccineCycleDate")));
        predicates.add(criteriaBuilder.isNotNull(root.get("vaccineFlexibleDate")));
        predicates.add(criteriaBuilder.greaterThan(root.get("vaccineFlexibleDate"), LocalDate.now()));

        if (criteria.getExaminationId() != null)
            predicates.add(criteriaBuilder.notEqual(root.get("id"), criteria.getExaminationId()));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
