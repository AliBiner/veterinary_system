package com.alibiner.specifications.vaccine;

import java.util.*;
import com.alibiner.entities.Vaccine;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

public class VaccineSpecification implements Specification<Vaccine> {
    private final VaccineSearchCriteria criteria;

    public VaccineSpecification(@NonNull VaccineSearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<Vaccine> root, CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getName() != null && !criteria.getName().isEmpty())
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + criteria.getName().toLowerCase() + "%"));

        if (criteria.getDescription() != null && !criteria.getDescription().isEmpty())
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + criteria.getDescription().toLowerCase() + "%"));

        if (criteria.getCode() != null && !criteria.getCode().isEmpty())
            predicates.add(criteriaBuilder.like(root.get("code"), "%" + criteria.getCode().toUpperCase() + "%"));

        if (criteria.getStatus() != null)
            predicates.add(criteriaBuilder.equal(root.get("isActive"), criteria.getStatus()));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
