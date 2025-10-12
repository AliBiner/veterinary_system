package com.alibiner.specifications.species;

import java.util.*;
import com.alibiner.entities.Species;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class SpeciesSpecification implements Specification<Species> {
    private final SpeciesSearchCriteria criteria;

    public SpeciesSpecification(SpeciesSearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Species> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria != null && criteria.getName() != null && criteria.getName().isEmpty())
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + criteria.getName().toLowerCase() + "%"));

        predicates.add(criteriaBuilder.isFalse(root.get("isDelete")));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
