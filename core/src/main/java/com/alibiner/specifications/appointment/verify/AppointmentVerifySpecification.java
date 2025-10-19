package com.alibiner.specifications.appointment.verify;

import java.util.*;
import com.alibiner.entities.Appointment;
import com.alibiner.enums.AppointmentStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

public class AppointmentVerifySpecification implements Specification<Appointment> {

    private final static List<AppointmentStatus> notAvailableStatuses = List.of(AppointmentStatus.RESERVED, AppointmentStatus.COMPLETED);
    private final AppointmentVerifyCriteria criteria;

    public AppointmentVerifySpecification(@NonNull AppointmentVerifyCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Appointment> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(root.join("doctor").get("id"), criteria.getDoctorId()));
        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), criteria.getAppointmentDate()));
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("finishDate"), criteria.getAppointmentDate()));

        predicates.add(criteriaBuilder.and(root.get("status").in(notAvailableStatuses)));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
