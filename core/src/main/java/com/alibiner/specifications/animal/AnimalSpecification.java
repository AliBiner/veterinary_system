package com.alibiner.specifications.animal;


import java.util.*;
import com.alibiner.entities.Animal;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

public class AnimalSpecification implements Specification<Animal> {

    private final AnimalSearchCriteria criteria;

    public AnimalSpecification(AnimalSearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<Animal> root, CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria != null) {
            if (criteria.getAnimalName() != null && !criteria.getAnimalName().isEmpty())
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + criteria.getAnimalName().toLowerCase() + "%"));

            if (criteria.getOwnerPhone() != null && !criteria.getOwnerPhone().isEmpty())
                predicates.add(criteriaBuilder.like(root.join("user").get("phone"), criteria.getOwnerPhone()));


            if (criteria.getOwnerMail() != null && !criteria.getOwnerMail().isEmpty())
                predicates.add(criteriaBuilder.like(root.join("user").get("mail"), criteria.getOwnerMail()));

            predicates.add(criteriaBuilder.isFalse(root.get("isDelete")));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
