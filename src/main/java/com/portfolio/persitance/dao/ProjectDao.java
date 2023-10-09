package com.portfolio.persitance.dao;

import com.portfolio.persitance.entities.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {
    List<Project> getAll();
    Optional<Project> getById(Integer id);
    Project save(Project project);
    boolean update(Project project);
    boolean deleteById(Integer id);
}
