package com.Major.majorProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class CafeAdditionDto {
    private long id;
    private String name;
    private String address;
    private LocalTime openTime;
    private LocalTime closeTime;
    private double hourlyRate;
}
