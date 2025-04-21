package com.javalab.raceservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private LocalDate date;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(foreignKey = @ForeignKey(name = "raceId"))
    private Set<RaceResult> results;
}

