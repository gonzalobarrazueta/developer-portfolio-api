package com.portfolio.services;

import com.portfolio.models.dtos.TechnologyDTO;
import com.portfolio.models.dtos.TechnologyMapper;
import com.portfolio.persitance.dao.TechnologyDao;
import com.portfolio.persitance.entities.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TechnologyService {

    private final TechnologyDao technologyDao;
    private final TechnologyMapper technologyMapper;

    @Autowired
    public TechnologyService(TechnologyDao technologyDao,
                             TechnologyMapper technologyMapper) {
        this.technologyDao = technologyDao;
        this.technologyMapper = technologyMapper;
    }

    public List<TechnologyDTO> getAllTechnologies() {
        return technologyDao.getAll()
                .stream()
                .map(technology -> technologyMapper.technologyToTechnologyDTO(technology))
                .toList();
    }

    public Optional<Technology> getById(UUID id) {
        return technologyDao.getById(id);
    }

    public Technology save(Technology tech) {
        if (technologyDao.existsByName(tech.getName())) {
            return technologyDao.getByName(tech.getName()).get();
        } else {
            return technologyDao.save(tech);
        }
    }

    public boolean update(Technology technology) {
        if (technologyDao.update(technology)) {
            return true;
        } else {
            throw new IllegalArgumentException("Technology with id " + technology.getId() + " does not exist");
        }
    }

    public boolean delete (UUID id) {
        if (technologyDao.deleteById(id)) {
            return true;
        } else {
            throw new IllegalArgumentException("Technology with id " + id + " does not exist");
        }
    }

    public boolean existsByName(String name) {
        return technologyDao.existsByName(name);
    }
}
