package com.javalab.raceservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class RaceResultDto {
    private Long driverId;
    private Integer driverPosition;
    private String driverName;
}
