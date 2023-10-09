package com.portfolio.models.dtos;

import com.portfolio.persitance.entities.Technology;
import org.springframework.stereotype.Service;

@Service
public class TechnologyMapper {

    public static TechnologyDTO technologyToTechnologyDTO(Technology technology) {
        return new TechnologyDTO(
                technology.getName()
        );
    }

    public static Technology technologyDTOToTechnology(TechnologyDTO technologyDTO) {
        Technology technology = new Technology();

        technology.setName(technologyDTO.getName());

        return technology;
    }
}

