package com.javalab.teamservice.repositories;

import com.javalab.teamservice.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
