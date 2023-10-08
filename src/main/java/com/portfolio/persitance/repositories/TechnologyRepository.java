package com.portfolio.persitance.repositories;

import com.portfolio.persitance.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
