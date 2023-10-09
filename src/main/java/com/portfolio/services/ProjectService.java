package com.portfolio.services;

import com.portfolio.models.dtos.ProjectDTO;
import com.portfolio.models.dtos.ProjectMapper;
import com.portfolio.persitance.dao.ProjectDao;
import com.portfolio.persitance.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectDao projectDao;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectService(ProjectDao projectDao,
                          ProjectMapper projectMapper) {
        this.projectDao = projectDao;
        this.projectMapper = projectMapper;
    }

    public List<ProjectDTO> getAllProjects() {
        return projectDao.getAll()
                .stream()
                .map(project -> projectMapper.projectToProjectDTO(project))
                .toList();
    }

    public Optional<ProjectDTO> getProjectById(Integer id) {
        return projectDao.getById(id)
                .map(project -> projectMapper.projectToProjectDTO(project));
    }

    public ProjectDTO save(ProjectDTO projectDTO) {
        Project project = projectMapper.projectDTOToProject(projectDTO);
        return projectMapper.projectToProjectDTO(projectDao.save(project));
    }

    public boolean update(Project project) {
        if (projectDao.update(project)) {
            return true;
        } else {
            throw new IllegalArgumentException("Project with id " + project.getId() + " does not exist");
        }
    }

    public boolean delete(Integer id) {
        if (projectDao.deleteById(id)) {
            return true;
        } else {
            throw new IllegalArgumentException("Project with id " + id + " does not exist");
        }
    }
}
