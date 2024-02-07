package com.example.electronicdevicesservice.controller;

import com.example.electronicdevicesservice.dto.*;
import com.example.electronicdevicesservice.service.ElectronicDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AnalyticController {

private final ElectronicDeviceService electronicDeviceService;

    @GetMapping("/top-five-factory")
    public List<TopFiveFactoryDto> getTopFiveFactory(){
        return electronicDeviceService.topFiveFactory();
    }
    @GetMapping("/top-five-device")
    public List<TopFiveDeviceResponseDto>  getTopFiveDevice(){
       return electronicDeviceService.topFiveDevice();
    }
    @GetMapping("/info-device")
    public List<StatisticDto>  getInfoDevice(){
        return electronicDeviceService.getInfoDevice();
    }

}
