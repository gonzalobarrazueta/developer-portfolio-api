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

@RestController
@RequestMapping("api/v1/technologies")
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
    public ResponseEntity<Optional<TechnologyDTO>> getTechnologyById(@PathVariable Integer id) {

        Optional<TechnologyDTO> response = technologyService.getById(id);

        if (response.isPresent()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<Void> save(@RequestBody TechnologyDTO technologyDTO) {
        technologyService.save(technologyDTO);
        return ResponseEntity.created(URI.create("api/v1/technologies")).build();
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
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            technologyService.delete(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

}
