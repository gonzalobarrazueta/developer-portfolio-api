package com.portfolio.controllers;

import com.portfolio.models.dtos.TechnologyDTO;
import com.portfolio.persitance.entities.Technology;
import com.portfolio.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/technologies")
@CrossOrigin
public class TechnologyController {

    private final TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<TechnologyDTO>> getAllTechnologies() {
        List<TechnologyDTO> response = technologyService.getAllTechnologies();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Technology> getTechnologyById(@PathVariable UUID id) {

        Optional<Technology> response = technologyService.getById(id);

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<Technology> save(@RequestBody Technology tech) {
        return ResponseEntity.ok(technologyService.save(tech));
    }

    @PutMapping(value = "", produces = "application/json")
    public ResponseEntity update(@RequestBody Technology technology) {
        try {
            technologyService.update(technology);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity delete(@PathVariable UUID id) {
        try {
            technologyService.delete(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

}
