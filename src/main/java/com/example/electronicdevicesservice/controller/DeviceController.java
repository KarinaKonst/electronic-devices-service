package com.example.electronicdevicesservice.controller;

import com.example.electronicdevicesservice.dto.AddNewDeviceDto;
import com.example.electronicdevicesservice.dto.DeviceDto;
import com.example.electronicdevicesservice.dto.FactoryDto;
import com.example.electronicdevicesservice.service.ElectronicDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class DeviceController {

    private final ElectronicDeviceService electronicDeviceService;

    @GetMapping("/get-list-devices")
    public List<DeviceDto> getListDevice(@RequestParam(required = false)String nameSupervisor,
                                         @RequestParam(required = false)String nameFactory){
        return  electronicDeviceService.getListDevice(nameSupervisor,nameFactory);
    }
    @PostMapping("/add-new-device")
    public String addNewDevice(@RequestBody AddNewDeviceDto addNewDeviceDto){
        electronicDeviceService.addNewDevice(addNewDeviceDto);
        return "Устройство успешно добавлено!";
    }
    @DeleteMapping("/delete-device")
    public String deleteDevice(@RequestParam Long id){
        electronicDeviceService.deleteDevice(id);
        return "Устройство успешно удалено из БД!";
    }

}
