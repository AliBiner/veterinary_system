package com.alibiner.specifications.availableDate;

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
        Predicate predicate = null;
        if (criteria != null) {
            if (criteria.getMinDate() == null && criteria.getMaxDate() == null) {
                return predicate;
            } else if (criteria.getMinDate() != null && criteria.getMaxDate() == null)
                predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("availableDate"), criteria.getMinDate());
            else if (criteria.getMinDate() == null)
                predicate = criteriaBuilder.lessThanOrEqualTo(root.get("availableDate"), criteria.getMaxDate());
            else
                predicate = criteriaBuilder.between(root.get("availableDate"), criteria.getMinDate(), criteria.getMaxDate());
        }
        return predicate;
    }
}
