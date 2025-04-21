package com.javalab.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    private Long id;
    private String name;
    private String nationality;
    private Integer age;
    private String gender;

    private Long teamId;
}
