package com.javalab.driverservice.services;

import com.javalab.driverservice.models.Driver;

import java.util.List;

public interface DriverService {

    Driver getDriver(Long id);
    List<Driver> getAllDrivers();
    Driver addDriver(Driver driver);
}
