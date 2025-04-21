package com.javalab.raceservice.repositories;

import com.javalab.raceservice.models.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {
}
