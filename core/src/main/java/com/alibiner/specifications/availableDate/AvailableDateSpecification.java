package com.alibiner.specifications.availableDate;

import java.util.*;
import com.alibiner.entities.AvailableDate;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;


public class AvailableDateSpecification implements Specification<AvailableDate> {

    private final AvailableDateSearchCriteria criteria;

    public AvailableDateSpecification(AvailableDateSearchCriteria criteria) {
        this.criteria = criteria;
    }


    @Override
    public Predicate toPredicate(@NonNull Root<AvailableDate> root, CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (criteria != null) {
            if (criteria.getMinDate() == null && criteria.getMaxDate() == null) {

            } else if (criteria.getMinDate() != null && criteria.getMaxDate() == null)
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("availableDate"), criteria.getMinDate()));
            else if (criteria.getMinDate() == null)
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("availableDate"), criteria.getMaxDate()));
            else
                predicates.add(criteriaBuilder.between(root.get("availableDate"), criteria.getMinDate(), criteria.getMaxDate()));
            if (criteria.getDoctorId() != null)
                predicates.add(criteriaBuilder.equal(root.join("user").get("id"), criteria.getDoctorId()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
