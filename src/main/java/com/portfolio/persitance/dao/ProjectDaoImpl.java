package com.portfolio.persitance.dao;

import com.portfolio.persitance.entities.Project;
import com.portfolio.persitance.repositories.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    private ProjectRepository projectRepository;

    public ProjectDaoImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getById(UUID id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public boolean update(Project project) {
        if (projectRepository.existsById(project.getId())) {
            projectRepository.save(project);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(UUID id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
