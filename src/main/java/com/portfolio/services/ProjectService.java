package com.portfolio.services;

import com.portfolio.models.dtos.ProjectDTO;
import com.portfolio.models.dtos.ProjectMapper;
import com.portfolio.persitance.dao.ProjectDao;
import com.portfolio.persitance.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ProjectDTO save(ProjectDTO projectDTO) {
        Project project = projectMapper.projectDTOToProject(projectDTO);
        return projectMapper.projectToProjectDTO(projectDao.save(project));
    }
}
