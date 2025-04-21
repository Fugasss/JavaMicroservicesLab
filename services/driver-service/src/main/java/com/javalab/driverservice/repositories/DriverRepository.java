package com.javalab.driverservice.repositories;

import com.javalab.driverservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
