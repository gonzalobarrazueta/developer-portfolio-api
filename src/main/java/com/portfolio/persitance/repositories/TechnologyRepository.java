package com.portfolio.persitance.repositories;

import com.portfolio.persitance.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TechnologyRepository extends JpaRepository<Technology, UUID> {
    boolean existsByName(String name);
    Optional<Technology> getByName(String name);
}
