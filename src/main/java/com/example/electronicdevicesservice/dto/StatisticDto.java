package com.example.electronicdevicesservice.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class StatisticDto {
    private LocalDate dateRelease;
    private int count;

}
