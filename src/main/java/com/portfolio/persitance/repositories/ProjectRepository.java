package com.portfolio.persitance.repositories;

import com.portfolio.persitance.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
