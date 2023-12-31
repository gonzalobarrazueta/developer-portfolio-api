package com.portfolio.persitance.repositories;

import com.portfolio.persitance.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
    boolean existsByPageId(String pageId);
    Optional<Project> findByPageId(String pageId);
}
