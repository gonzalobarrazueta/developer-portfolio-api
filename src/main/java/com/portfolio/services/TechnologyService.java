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

    public Optional<TechnologyDTO> getById(UUID id) {
        return technologyDao.getById(id)
                .map(technology -> technologyMapper.technologyToTechnologyDTO(technology));
    }

    public TechnologyDTO save(TechnologyDTO technologyDTO) {
        return technologyMapper.technologyToTechnologyDTO(
                technologyDao.save(
                        technologyMapper.technologyDTOToTechnology(technologyDTO)
                )
        );
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
}
