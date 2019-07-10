package com.spring.microservices.repository;

import java.util.UUID;

import com.spring.microservices.model.Profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    Profile findByUserId(UUID userId);
}