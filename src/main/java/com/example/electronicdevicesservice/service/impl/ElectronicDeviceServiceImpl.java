package com.example.electronicdevicesservice.service.impl;

import com.example.electronicdevicesservice.dao.ElectronicDeviceDao;
import com.example.electronicdevicesservice.dto.*;
import com.example.electronicdevicesservice.entity.DeviceEntity;
import com.example.electronicdevicesservice.entity.FactoryEntity;
import com.example.electronicdevicesservice.mapper.FullMapper;
import com.example.electronicdevicesservice.repository.DeviceRepository;
import com.example.electronicdevicesservice.repository.FactoryRepository;
import com.example.electronicdevicesservice.service.ElectronicDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ElectronicDeviceServiceImpl implements ElectronicDeviceService {

    private final FactoryRepository factoryRepository;
    private final DeviceRepository deviceRepository;
    private final FullMapper fullMapper;
    private final ElectronicDeviceDao factoryDao;

    @Override
    public List<FactoryDto> getListFactory() {
        List<FactoryEntity> listFactory = factoryRepository.findAll();
        List<FactoryDto> factoryDtoList = new ArrayList<>();
        for (FactoryEntity a : listFactory) {
            FactoryDto factoryDto = fullMapper.factoryEntityToFactoryDto(a);
            factoryDtoList.add(factoryDto);
        }
        return factoryDtoList;
    }

    @Override
    public void addNewFactory(FactoryDto factoryDto) {
        FactoryEntity factoryEntity = fullMapper.factoryDtoToFactoryEntity(factoryDto);
        factoryRepository.save(factoryEntity);

    }

    @Override
    public void deleteFactory(String name) {
        FactoryEntity factoryEntityByName = factoryRepository.getFactoryEntityByName(name);
        factoryRepository.delete(factoryEntityByName);
    }

    @Override
    public List<DeviceDto> getListDevice(String nameSupervisor, String nameFactory) {
        if (!isNull(nameSupervisor) && !isNull(nameFactory)) {
            List<DeviceEntity> deviceList = deviceRepository.getDeviceEntitiesBySupervisorAndNameFactory(nameSupervisor, nameFactory);
            return getListDeviceDto(deviceList);
        }
        if (!isNull(nameSupervisor)) {
            List<DeviceEntity> deviceList = deviceRepository.getDeviceEntitiesBySupervisor(nameSupervisor);
            return getListDeviceDto(deviceList);
        }
        if (!isNull(nameFactory)) {
            List<DeviceEntity> deviceList = deviceRepository.getDeviceEntitiesByNameFactory(nameFactory);
            return getListDeviceDto(deviceList);
        }
        return getListDeviceDto(deviceRepository.findAll());
    }

    @Override
    public void addNewDevice(AddNewDeviceDto addNewDeviceDto) {
        DeviceEntity deviceEntity = fullMapper.newDeviceDtoToDeviceEntity(addNewDeviceDto);
        String nameFactory = addNewDeviceDto.getNameFactory();
        FactoryEntity factoryEntityByName = factoryRepository.getFactoryEntityByName(nameFactory);
        deviceEntity.setFactoryId(factoryEntityByName);
        deviceRepository.save(deviceEntity);

    }

    @Override
    public void deleteDevice(Long id) {
        DeviceEntity deviceById = deviceRepository.getDeviceById(id);
        deviceRepository.delete(deviceById);
    }

    @Override
    public List<TopFiveFactoryDto> topFiveFactory() {
      return   factoryDao.getTopFiveFactory();
    }

    @Override
    public List<TopFiveDeviceResponseDto> topFiveDevice() {
        return factoryDao.getTopFiveDeviseDto();

    }

    @Override
    public List<StatisticDto> getInfoDevice() {
       return factoryDao.getInfoDevice();
    }


    private List<DeviceDto> getListDeviceDto(List<DeviceEntity> list) {
        List<DeviceDto> dtoList = new ArrayList<>();
        for (DeviceEntity b : list) {
            DeviceDto deviceDto = fullMapper.deviceEntityToDeviceDto(b);
            dtoList.add(deviceDto);

        }
        return dtoList;
    }

}
