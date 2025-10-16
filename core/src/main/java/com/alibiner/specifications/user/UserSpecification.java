package com.alibiner.specifications.user;

import java.util.*;
import com.alibiner.entities.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification implements Specification<User> {

    private final UserSearchCriteria criteria;

    public UserSpecification(UserSearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria != null) {
            if (criteria.getName() != null && !criteria.getName().isEmpty())
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + criteria.getName().toLowerCase() + "%"));
            if (criteria.getPhone() != null && !criteria.getPhone().isEmpty())
                predicates.add(criteriaBuilder.like(root.get("phone"), "%" + criteria.getPhone() + "%"));
            if (criteria.getMail() != null && !criteria.getMail().isEmpty())
                predicates.add(criteriaBuilder.like(root.get("mail"), "%" + criteria.getMail() + "%"));
        }

        Predicate orPredicates = criteriaBuilder.or(predicates.toArray(new Predicate[0]));

        Predicate isDelete = criteriaBuilder.isFalse(root.get("isDelete"));

        return criteriaBuilder.and(orPredicates, isDelete);
    }
}
