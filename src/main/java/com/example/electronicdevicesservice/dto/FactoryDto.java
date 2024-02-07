package com.example.electronicdevicesservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class FactoryDto {
    private String name;
    private String address;
    private LocalDate dateConstruction;
    private LocalDate dateAddition;
}
