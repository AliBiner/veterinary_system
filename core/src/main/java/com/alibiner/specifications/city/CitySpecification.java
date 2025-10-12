package com.alibiner.specifications.city;


import java.util.*;
import com.alibiner.entities.City;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class CitySpecification implements Specification<City> {
    private final CitySearchCriteria criteria;

    public CitySpecification(CitySearchCriteria citySearchCriteria) {
        criteria = citySearchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getName() != null && !criteria.getName().isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + criteria.getName().toLowerCase() + "%"));
        }

        predicates.add(criteriaBuilder.isFalse(root.get("isDelete")));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
