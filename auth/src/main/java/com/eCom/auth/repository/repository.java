package com.eCom.auth.repository;

import com.eCom.auth.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface repository extends JpaRepository<AuthEntity,Integer> {
    Optional<AuthEntity> findById(Integer id);
}
