package com.example.electronicdevicesservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@Table(name="factory")
public class FactoryEntity {
    @Id
    @SequenceGenerator(name="factorySequence", sequenceName="factory_sequence", allocationSize = 1,initialValue =7)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="factorySequence")
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private  String name;

    @Column(name="address")
    private String address;

    @Column(name="date_construction")
    private LocalDate dateOfConstruction;

    @Column(name="date_addition")
    private LocalDate dateOfAddition;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "factoryId")
    private List<DeviceEntity> deviceEntityList;
}
