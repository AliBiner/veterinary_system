package com.alibiner.specifications.appointment.search;


import java.util.*;
import com.alibiner.entities.Appointment;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

public class AppointmentSearchSpecification implements Specification<Appointment> {

    private final AppointmentSearchCriteria criteria;

    public AppointmentSearchSpecification(@NonNull AppointmentSearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<Appointment> root, CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {


        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getDoctorId() != null)
            predicates.add(criteriaBuilder.equal(root.join("doctor").get("id"), criteria.getDoctorId()));
        if (criteria.getOwnerId() != null)
            predicates.add(criteriaBuilder.equal(root.join("animal").join("user").get("id"), criteria.getOwnerId()));
        if (criteria.getAnimalId() != null)
            predicates.add(criteriaBuilder.equal(root.join("animal").get("id"), criteria.getAnimalId()));
        predicates.add(criteriaBuilder.equal(root.get("status"), criteria.getStatus()));
        predicates.add(criteriaBuilder.between(root.get("startDate"), criteria.getMinDate(), criteria.getMaxDate()));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
