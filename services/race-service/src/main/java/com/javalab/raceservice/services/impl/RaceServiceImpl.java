package com.javalab.raceservice.services.impl;

import com.javalab.raceservice.models.Race;
import com.javalab.raceservice.models.RaceResult;
import com.javalab.raceservice.repositories.RaceRepository;
import com.javalab.raceservice.repositories.RaceResultRepository;
import com.javalab.raceservice.services.RaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    private final RaceResultRepository raceResultRepository;

    @Override
    public Race getRace(Long id) {
        return raceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    @Override
    public Race addRace(Race race) {
        Race savedRace = raceRepository.save(race);

        for (RaceResult result : race.getResults()) result.setRace(savedRace);

        raceResultRepository.saveAll(race.getResults());

        return savedRace;
    }
}
