package com.portfolio.persitance.dao;

import com.portfolio.persitance.entities.Project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectDao {
    List<Project> getAll();
    Optional<Project> getById(UUID id);
    Project save(Project project);
    boolean update(Project project);
    boolean deleteById(UUID id);
    boolean existsByPageId(String pageId);
    Optional<Project> getByPageId(String pageId);
}
