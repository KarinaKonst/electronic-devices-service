package com.example.electronicdevicesservice.service;

import com.example.electronicdevicesservice.dto.*;
import com.example.electronicdevicesservice.entity.DeviceEntity;
import com.example.electronicdevicesservice.entity.FactoryEntity;

import java.util.List;

public interface ElectronicDeviceService {

    public List<FactoryDto> getListFactory();
    public void addNewFactory(FactoryDto factoryDto);
    public void deleteFactory(String name);

    public List<DeviceDto> getListDevice(String nameSupervisor,String nameFactory);
    public void addNewDevice(AddNewDeviceDto addNewDeviceDto);
    public void deleteDevice(Long id);
    public List<TopFiveFactoryDto> topFiveFactory();
    public List<TopFiveDeviceResponseDto>  topFiveDevice();
    public List<StatisticDto> getInfoDevice();
}
