package com.portfolio.persitance.dao;

import com.portfolio.persitance.entities.Technology;
import io.micrometer.observation.ObservationFilter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TechnologyDao {
    List<Technology> getAll();
    Optional<Technology> getById(UUID id);
    Technology save(Technology technology);
    boolean update(Technology technology);
    boolean deleteById(UUID id);
    boolean existsByName(String name);
    Optional<Technology> getByName(String name);
}
