package com.eCom.repository;

import com.eCom.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AuthEntity, Long> {

    Optional<AuthEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
