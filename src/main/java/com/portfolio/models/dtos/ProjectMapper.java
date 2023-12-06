package com.portfolio.models.dtos;

import com.portfolio.persitance.entities.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMapper {

    public static ProjectDTO projectToProjectDTO(Project project) {

        List<TechnologyDTO> technologies = List.of();

        if (project.getTechnologies() != null) {
            technologies = project.getTechnologies()
                    .stream()
                    .map(technology -> TechnologyMapper.technologyToTechnologyDTO(technology))
                    .toList();
        }

        return new ProjectDTO(
                project.getPageId(),
                project.getTitle(),
                project.getDescription(),
                project.getImageUrl(),
                technologies,
                project.getDemo(),
                project.getGithub(),
                project.getLive()
        );
    }

    public static Project projectDTOToProject(ProjectDTO projectDTO) {
        Project project = new Project();

        project.setPageId(projectDTO.getPageId());
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());
        project.setImageUrl(projectDTO.getImageUrl());
        project.setDemo(projectDTO.getDemo());
        project.setGithub(projectDTO.getGithub());
        project.setLive(projectDTO.getLive());

        return project;
    }
}
