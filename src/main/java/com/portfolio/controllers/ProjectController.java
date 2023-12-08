package com.portfolio.controllers;

import com.portfolio.models.dtos.ProjectDTO;
import com.portfolio.persitance.entities.Project;
import com.portfolio.persitance.entities.Technology;
import com.portfolio.services.ProjectService;
import com.portfolio.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/projects")
@CrossOrigin
public class ProjectController {

    private final ProjectService projectService;
    private final TechnologyService technologyService;

    @Autowired
    public ProjectController(ProjectService projectService, TechnologyService technologyService) {
        this.projectService = projectService;
        this.technologyService = technologyService;
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> response = projectService.getAllProjects();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Project> getProjectById(@PathVariable UUID id) {

        Optional<Project> response = projectService.getProjectById(id);

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity save(@RequestBody Project project) {

        List<Technology> projectTechnologies = new ArrayList<>();

        for (Technology technology : project.getTechnologies()) {
            projectTechnologies.add(technologyService.save(technology));
        }

        project.setTechnologies(projectTechnologies);

        return ResponseEntity.ok(projectService.save(project));
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
    public ResponseEntity delete(@PathVariable UUID id) {
        try {
            projectService.delete(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
}
