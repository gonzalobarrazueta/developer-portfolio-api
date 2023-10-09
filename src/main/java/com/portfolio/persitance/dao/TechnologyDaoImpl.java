package com.portfolio.persitance.dao;

import com.portfolio.persitance.entities.Technology;
import com.portfolio.persitance.repositories.TechnologyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TechnologyDaoImpl implements TechnologyDao {

    private TechnologyRepository technologyRepository;

    public TechnologyDaoImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public List<Technology> getAll() {
        return technologyRepository.findAll();
    }

    @Override
    public Optional<Technology> getById(Integer id) {
        return technologyRepository.findById(id);
    }

    @Override
    public Technology save(Technology technology) {
        return technologyRepository.save(technology);
    }

    @Override
    public boolean update(Technology technology) {
        if (technologyRepository.existsById(technology.getId())) {
            technologyRepository.save(technology);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        if (technologyRepository.existsById(id)) {
            technologyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
