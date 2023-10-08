package com.portfolio.services;

import com.portfolio.models.dtos.TechnologyDTO;
import com.portfolio.models.dtos.TechnologyDTOMapper;
import com.portfolio.persitance.dao.TechnologyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    private final TechnologyDao technologyDao;
    private final TechnologyDTOMapper technologyDTOMapper;

    @Autowired
    public TechnologyService(TechnologyDao technologyDao,
                             TechnologyDTOMapper technologyDTOMapper) {
        this.technologyDao = technologyDao;
        this.technologyDTOMapper = technologyDTOMapper;
    }

    public List<TechnologyDTO> getAllTechnologies() {
        return technologyDao.getAll()
                .stream()
                .map(technologyDTOMapper)
                .toList();
    }
}
