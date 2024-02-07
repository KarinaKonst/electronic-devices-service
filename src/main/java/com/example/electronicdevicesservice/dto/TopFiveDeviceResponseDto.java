package com.example.electronicdevicesservice.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class TopFiveDeviceResponseDto {
    private Date dateRelease;
    private String nameSupervisor;
    private String name;
}
