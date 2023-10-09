package com.portfolio.controllers;

import com.portfolio.models.dtos.ProjectDTO;
import com.portfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> response = projectService.getAllProjects();
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<ProjectDTO> save(@RequestBody ProjectDTO projectDTO) {
        ProjectDTO response = projectService.save(projectDTO);
        return ResponseEntity.ok(response);
    }
}
