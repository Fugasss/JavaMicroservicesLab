package com.javalab.driverservice.models.mappers;

import com.javalab.common.dto.DriverDto;
import com.javalab.driverservice.models.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DriverMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "nationality", target = "nationality")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "teamId", target = "teamId")
    DriverDto toDto(Driver driver);

    Driver toEntity(DriverDto driverDto);

    List<DriverDto> toDto(List<Driver> drivers);
}
