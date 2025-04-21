package com.javalab.driverservice.controllers;

import com.javalab.common.dto.DriverDto;
import com.javalab.driverservice.models.Driver;
import com.javalab.driverservice.models.mappers.DriverMapper;
import com.javalab.driverservice.services.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;
    private final DriverMapper mapper;

    @GetMapping("/{id}")
    public DriverDto getDriverById(@PathVariable Long id) {
        Driver entity = driverService.getDriver(id);
        return mapper.toDto(entity);
    }

    @GetMapping
    public List<DriverDto> getAllDrivers() {
        List<Driver> allEntities = driverService.getAllDrivers();
        return mapper.toDto(allEntities);
    }

    @PostMapping
    public DriverDto createDriver(@RequestBody DriverDto driver) {
        log.info("Creating new driver: {}", driver);
        Driver entity = mapper.toEntity(driver);

        if(entity.getId() != null){
            log.warn("ID shouldn't be declared when creating new entity: {}\n ID changed to NULL", entity);
            entity.setId(null);
        }

        entity = driverService.addDriver(entity);

        log.info("New driver: {}", entity);

        return mapper.toDto(entity);
    }
}
