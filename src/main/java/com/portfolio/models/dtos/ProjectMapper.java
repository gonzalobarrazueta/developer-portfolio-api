package com.portfolio.models.dtos;

import com.portfolio.persitance.entities.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectMapper {

    public static ProjectDTO projectToProjectDTO(Project project) {
        return new ProjectDTO(
                project.getPageId(),
                project.getTitle(),
                project.getDescription(),
                project.getImageUrl()
        );
    }

    public static Project projectDTOToProject(ProjectDTO projectDTO) {
        Project project = new Project();

        project.setPageId(projectDTO.getPageId());
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());
        project.setImageUrl(projectDTO.getImageUrl());

        return project;
    }
}
