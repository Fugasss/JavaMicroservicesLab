package com.javalab.driverservice.services.impl;

import com.javalab.driverservice.models.Driver;
import com.javalab.driverservice.repositories.DriverRepository;
import com.javalab.driverservice.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Override
    public Driver getDriver(Long id) {
        return driverRepository.findById(id).orElse(null);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }
}
