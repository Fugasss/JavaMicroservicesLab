package com.javalab.raceservice.controllers;

import com.javalab.raceservice.dto.RaceDto;
import com.javalab.raceservice.models.Race;
import com.javalab.raceservice.models.mappers.RaceMapper;
import com.javalab.raceservice.services.RaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RaceController {

    private final RaceService driverService;
    private final RaceMapper mapper;

    @GetMapping("/{id}")
    public RaceDto getRaceById(@PathVariable Long id) {
        Race race = driverService.getRace(id);
        return mapper.toDto(race);
    }

    @GetMapping
    public List<RaceDto> getAllRaces() {
        List<Race> races = driverService.getAllRaces();
        return mapper.toDto(races);
    }

    @PostMapping
    public RaceDto createRace(@RequestBody RaceDto race) {
        Race entity = driverService.addRace(mapper.toEntity(race));
        return mapper.toDto(entity);
    }

    @GetMapping("/winner")
    public RaceDto getLastRaceAndWinner() {
        RaceDto dto = mapper.toDto(driverService.getLastRace());

        if (dto != null)
            dto.setResults(dto.getResults().stream().filter(driver -> driver.getDriverPosition() == 1).toList());

        return dto;
    }
}
