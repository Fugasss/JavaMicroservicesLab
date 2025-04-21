package com.javalab.teamservice.services;

import com.javalab.common.dto.DriverDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "driver-service")
public interface DriverService {
    @GetMapping
    List<DriverDto> getAllDrivers();
}
