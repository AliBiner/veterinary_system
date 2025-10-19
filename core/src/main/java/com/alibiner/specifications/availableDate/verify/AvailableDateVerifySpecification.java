package com.alibiner.specifications.availableDate.verify;


import com.alibiner.entities.AvailableDate;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

public class AvailableDateVerifySpecification implements Specification<AvailableDate> {
    private final AvailableDateVerifyCriteria criteria;

    public AvailableDateVerifySpecification(@NonNull AvailableDateVerifyCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<AvailableDate> root, CriteriaQuery<?> query,
                                 @NonNull CriteriaBuilder criteriaBuilder) {
        Predicate equalId = criteriaBuilder.equal(root.join("user").get("id"), criteria.getDoctorId());
        Predicate equalAvailableDate = criteriaBuilder.equal(root.get("availableDate"), criteria.getAppointmentDate());
        return criteriaBuilder.and(equalId, equalAvailableDate);
    }
}
