package com.javalab.raceservice.services;

import com.javalab.common.dto.DriverMinimalDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "driver-service")
public interface DriverService {
    @GetMapping("/{id}")
    DriverMinimalDto getDriverById(@PathVariable Long id);

    @GetMapping
    List<DriverMinimalDto> getAllDrivers();
}

