package com.example.electronicdevicesservice.repository;

import com.example.electronicdevicesservice.entity.DeviceEntity;
import com.example.electronicdevicesservice.entity.FactoryEntity;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

    @Query("SELECT d FROM DeviceEntity  d WHERE d.supervisor = :nameSupervisor AND d.factoryId.name = :nameFactory")
    public List<DeviceEntity> getDeviceEntitiesBySupervisorAndNameFactory(String nameSupervisor, String nameFactory);

    @Query("SELECT d FROM DeviceEntity  d WHERE d.supervisor = :nameSupervisor")
    public List<DeviceEntity> getDeviceEntitiesBySupervisor(String nameSupervisor);

    @Query("SELECT d FROM DeviceEntity  d WHERE  d.factoryId.name = :nameFactory")
    public List<DeviceEntity> getDeviceEntitiesByNameFactory(String nameFactory);
    @Query("SELECT d FROM DeviceEntity  d WHERE  d.id = :id")
    public DeviceEntity getDeviceById(Long id);

}
