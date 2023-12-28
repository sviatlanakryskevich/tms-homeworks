package com.tms.lesson49rest_token.repository;

import com.tms.lesson49rest_token.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByLogin(String username);
}
