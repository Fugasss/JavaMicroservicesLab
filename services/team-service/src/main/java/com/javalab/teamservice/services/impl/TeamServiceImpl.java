package com.javalab.teamservice.services.impl;

import com.javalab.common.dto.DriverMinimalDto;
import com.javalab.teamservice.models.Team;
import com.javalab.teamservice.repositories.TeamRepository;
import com.javalab.teamservice.services.DriverService;
import com.javalab.teamservice.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository raceRepository;
    private final DriverService driverService;

    @Override
    public Team getTeam(Long id) {
        Team team = raceRepository.findById(id).orElse(null);
        fillData(team);
        return team;
    }

    @Override
    public List<Team> getAllTeams() {
        List<Team> teams = raceRepository.findAll();
        teams.forEach(this::fillData);
        return teams;
    }

    @Override
    public Team addTeam(Team driver) {
        Team team = raceRepository.save(driver);
        fillData(team);
        return team;
    }

    private void fillData(Team team) {
        if (team == null) return;

        List<DriverMinimalDto> driversData = driverService.getAllDrivers().stream()
                .filter(driver -> Objects.equals(driver.getTeamId(), team.getId()))
                .map(driver -> new DriverMinimalDto(driver.getId(), driver.getName()))
                .toList();

        team.setDrivers(driversData);
    }
}
