package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.AvailableDate;
import com.alibiner.entities.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, UUID>, JpaSpecificationExecutor<AvailableDate> {

    @Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = {DataIntegrityViolationException.class})
    default void updateOrInsert(AvailableDate entity) {
        save(entity);
    }

    List<AvailableDate> findAllByIdInAndUser(Collection<UUID> ids, User user);

    Page<AvailableDate> findAllByUser(User user, Pageable pageable, Specification<AvailableDate> specification);


}
