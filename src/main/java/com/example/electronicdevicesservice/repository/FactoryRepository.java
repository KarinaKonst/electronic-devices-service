package com.example.electronicdevicesservice.repository;

import com.example.electronicdevicesservice.entity.FactoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FactoryRepository extends JpaRepository<FactoryEntity,Long> {
    @Query("SELECT d FROM FactoryEntity  d WHERE  d.name = :name")
    FactoryEntity getFactoryEntityByName(String name);

}
