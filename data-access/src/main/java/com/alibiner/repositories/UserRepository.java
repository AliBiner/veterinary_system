package com.alibiner.repositories;

import java.util.*;
import com.alibiner.entities.User;
import com.alibiner.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {

    Optional<User> findByIdAndIsDeleteFalseAndUserType(UUID id, UserType userType);
}
