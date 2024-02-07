package com.example.electronicdevicesservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddNewDeviceDto {
    private Long id;
    private LocalDate dateRelease;
    private String nameSupervisor;
    private String nameFactory;
}
