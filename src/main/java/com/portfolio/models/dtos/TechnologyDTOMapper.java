package com.portfolio.models.dtos;

import com.portfolio.persitance.entities.Technology;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TechnologyDTOMapper implements Function<Technology, TechnologyDTO> {
    @Override
    public TechnologyDTO apply(Technology technology) {
        return new TechnologyDTO(
                technology.getName()
        );
    }
}
