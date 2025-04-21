package com.javalab.teamservice.models;

import com.javalab.common.dto.DriverMinimalDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

    @Transient
    private List<DriverMinimalDto> drivers;
}
