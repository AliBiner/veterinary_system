package com.alibiner.specifications.color;

import java.util.*;
import com.alibiner.entities.Color;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class ColorSpecification implements Specification<Color> {

    private final ColorSearchCriteria criteria;

    public ColorSpecification(ColorSearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Color> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (criteria != null && criteria.getName() != null && !criteria.getName().isEmpty())
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + criteria.getName().toLowerCase() + "%"));

        predicates.add(criteriaBuilder.isFalse(root.get("isDelete")));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
