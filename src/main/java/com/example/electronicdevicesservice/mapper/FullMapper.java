package com.example.electronicdevicesservice.mapper;

import com.example.electronicdevicesservice.dto.AddNewDeviceDto;
import com.example.electronicdevicesservice.dto.DeviceDto;
import com.example.electronicdevicesservice.dto.FactoryDto;
import com.example.electronicdevicesservice.entity.DeviceEntity;
import com.example.electronicdevicesservice.entity.FactoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FullMapper {
    public default FactoryDto factoryEntityToFactoryDto(FactoryEntity factoryEntity) {
        FactoryDto factoryDto = new FactoryDto();
        factoryDto.setName(factoryEntity.getName());
        factoryDto.setAddress(factoryEntity.getAddress());
        factoryDto.setDateConstruction(factoryEntity.getDateOfConstruction());
        factoryDto.setDateAddition(factoryEntity.getDateOfAddition());

        return factoryDto;
    }
    public default  FactoryEntity factoryDtoToFactoryEntity(FactoryDto factoryDto){
        FactoryEntity factoryEntity= new FactoryEntity();
        factoryEntity.setName(factoryDto.getName());
        factoryEntity.setAddress(factoryDto.getAddress());
        factoryEntity.setDateOfConstruction(factoryDto.getDateConstruction());
        factoryEntity.setDateOfAddition(factoryDto.getDateAddition());
        return factoryEntity;
    }
    public default DeviceDto deviceEntityToDeviceDto(DeviceEntity deviceEntity){
        DeviceDto deviceDto=new DeviceDto();
        deviceDto.setId(deviceEntity.getId());
        deviceDto.setDateRelease(deviceEntity.getDateofRelease());
        deviceDto.setNameSupervisor(deviceEntity.getSupervisor());
        deviceDto.setFactoryDto(factoryEntityToFactoryDto(deviceEntity.getFactoryId()));
        return deviceDto;
    }
    public default DeviceEntity deviceDtoToDeviceEntity(DeviceDto deviceDto){
        DeviceEntity deviceEntity=new DeviceEntity();
        deviceEntity.setId(deviceDto.getId());
        deviceEntity.setDateofRelease(deviceDto.getDateRelease());
        deviceEntity.setSupervisor(deviceDto.getNameSupervisor());
        FactoryDto factoryDto = deviceDto.getFactoryDto();
        FactoryEntity factoryEntity = factoryDtoToFactoryEntity(factoryDto);
        deviceEntity.setFactoryId(factoryEntity);
        return deviceEntity;
    }
public default DeviceEntity newDeviceDtoToDeviceEntity(AddNewDeviceDto addNewDeviceDto){
        DeviceEntity deviceEntity=new DeviceEntity();
        deviceEntity.setId(addNewDeviceDto.getId());
        deviceEntity.setDateofRelease(addNewDeviceDto.getDateRelease());
        deviceEntity.setSupervisor(addNewDeviceDto.getNameSupervisor());
        return deviceEntity;

}

}
