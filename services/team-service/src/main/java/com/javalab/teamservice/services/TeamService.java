package com.javalab.teamservice.services;

import com.javalab.teamservice.models.Team;

import java.util.List;

public interface TeamService {

    Team getTeam(Long id);
    List<Team> getAllTeams();
    Team addTeam(Team driver);
}
