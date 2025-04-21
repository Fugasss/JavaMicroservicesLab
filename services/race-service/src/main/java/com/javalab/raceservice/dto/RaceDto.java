package com.javalab.raceservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Getter
@Setter
public class RaceDto{
    private Long id;
    private String place;
    private LocalDate date;

    private List<RaceResultDto> results;
}


