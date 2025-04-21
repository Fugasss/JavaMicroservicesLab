package com.javalab.raceservice.models.mappers;

import com.javalab.common.dto.DriverMinimalDto;
import com.javalab.raceservice.dto.RaceDto;
import com.javalab.raceservice.dto.RaceResultDto;
import com.javalab.raceservice.models.Race;
import com.javalab.raceservice.models.RaceResult;
import com.javalab.raceservice.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RaceMapper {

    private final DriverService driverService;

    public RaceDto toDto(Race race) {
        if (race == null) {
            return null;
        }

        List<RaceResultDto> results = new ArrayList<>();

        for (RaceResult raceResult : race.getResults()) {
            DriverMinimalDto driverData = driverService.getDriverById(raceResult.getDriverId());

            RaceResultDto result = RaceResultDto.builder()
                    .driverId(driverData.getId())
                    .driverPosition(raceResult.getDriverPosition())
                    .driverName(driverData.getName())
                    .build();

            results.add(result);
        }

        return RaceDto.builder()
                .id(race.getId())
                .place(race.getPlace())
                .date(race.getDate())
                .results(results)
                .build();
    }

    public List<RaceDto> toDto(List<Race> races) {
        if (races == null) {
            return null;
        }

        List<RaceDto> results = new ArrayList<>();

        for (Race race : races) {
            if(race == null) { continue;}
            results.add(toDto(race));
        }

        return results;
    }

    public Race toEntity(RaceDto dto) {
        if (dto == null) {
            return null;
        }

        Race race = new Race();
        race.setId(dto.getId());
        race.setPlace(dto.getPlace());
        race.setDate(dto.getDate());

        Set<RaceResult> results = dto.getResults().stream()
                .map(resultDto -> {
                    RaceResult result = new RaceResult();
                    result.setDriverId(resultDto.getDriverId());
                    result.setDriverPosition(resultDto.getDriverPosition());
                    result.setRace(race);
                    return result;
                })
                .collect(Collectors.toSet());

        race.setResults(results);

        return race;
    }

}
