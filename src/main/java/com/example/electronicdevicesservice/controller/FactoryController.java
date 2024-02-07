package com.example.electronicdevicesservice.controller;

import com.example.electronicdevicesservice.dto.FactoryDto;
import com.example.electronicdevicesservice.entity.FactoryEntity;
import com.example.electronicdevicesservice.service.ElectronicDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FactoryController {

    private final ElectronicDeviceService electronicDeviceService;
    @GetMapping("/get-list-factories")
    public List<FactoryDto> getListFactory(){
        return  electronicDeviceService.getListFactory();
    }
    @PostMapping("/add-new-factory")
    public String addNewFactory(@RequestBody FactoryDto factoryDto){
        electronicDeviceService.addNewFactory(factoryDto);
        return "Завод успешно добавлен!";
    }
    @DeleteMapping("/delete-factory")
    public String deleteFactory(@RequestParam String name){
        electronicDeviceService.deleteFactory(name);
        return "Завод успешно удален из БД!";
    }

}
