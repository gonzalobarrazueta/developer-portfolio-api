package com.portfolio.controllers;

import com.portfolio.models.dtos.ProjectDTO;
import com.portfolio.persitance.entities.Project;
import com.portfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Integer id) {

        Optional<ProjectDTO> response = projectService.getProjectById(id);

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<ProjectDTO> save(@RequestBody ProjectDTO projectDTO) {
        projectService.save(projectDTO);
        return ResponseEntity.created(URI.create("api/v1/projects")).build();
    }

    @PutMapping(value = "", produces = "application/json")
    public ResponseEntity update(@RequestBody Project project) {
       try {
           projectService.update(project);
       } catch (IllegalArgumentException e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
       return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            projectService.delete(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
}
