package com.alibiner.specifications.examination.search;


import java.util.*;
import com.alibiner.entities.Examination;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

public class ExaminationSearchSpecification implements Specification<Examination> {

    private final ExaminationSearchCriteria criteria;

    public ExaminationSearchSpecification(@NonNull ExaminationSearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Examination> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getAnimalId() != null)
            predicates.add(criteriaBuilder.equal(root.join("appointment").join("animal").get("id"), criteria.getAnimalId()));
        if (criteria.getMinExaminationDate() != null)
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("examinationDate"), criteria.getMinExaminationDate()));
        if (criteria.getMaxExaminationDate() != null)
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("examinationDate"), criteria.getMaxExaminationDate()));
        if (criteria.getMinVaccineFlexibleCycleDate() != null)
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("vaccineFlexibleDate"), criteria.getMinVaccineFlexibleCycleDate()));
        if (criteria.getMaxVaccineFlexibleCycleDate() != null)
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("vaccineFlexibleDate"), criteria.getMaxVaccineFlexibleCycleDate()));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
