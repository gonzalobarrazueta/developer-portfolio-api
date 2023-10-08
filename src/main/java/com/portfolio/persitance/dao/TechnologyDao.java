package com.portfolio.persitance.dao;

import com.portfolio.persitance.entities.Technology;

import java.util.List;
import java.util.Optional;

public interface TechnologyDao {
    List<Technology> getAll();
    Optional<Technology> getById(Integer id);
    Technology save(Technology technology);
    Technology update(Technology technology);
    boolean deleteById(Integer id);
}
