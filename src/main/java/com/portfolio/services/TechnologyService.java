package com.portfolio.services;

import com.portfolio.models.dtos.TechnologyDTO;
import com.portfolio.models.dtos.TechnologyMapper;
import com.portfolio.persitance.dao.TechnologyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
