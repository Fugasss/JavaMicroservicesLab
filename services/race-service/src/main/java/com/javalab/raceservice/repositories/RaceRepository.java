package com.javalab.raceservice.repositories;

import com.javalab.raceservice.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
}
