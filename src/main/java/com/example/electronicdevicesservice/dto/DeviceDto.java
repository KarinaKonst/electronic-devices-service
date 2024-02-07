package com.example.electronicdevicesservice.dto;

import com.example.electronicdevicesservice.entity.FactoryEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class DeviceDto {
    private Long id;
    private LocalDate dateRelease;
    private String nameSupervisor;
    private FactoryDto factoryDto;

}
