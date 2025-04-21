package com.javalab.raceservice.services;

import com.javalab.raceservice.models.Race;

import java.util.List;

public interface RaceService {

    Race getRace(Long id);
    List<Race> getAllRaces();
    Race addRace(Race driver);
    Race getLastRace();
}
