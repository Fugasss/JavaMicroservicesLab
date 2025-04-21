package com.javalab.raceservice.repositories;

import com.javalab.raceservice.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Optional<Race> findFirstByOrderByDateDesc();
}
