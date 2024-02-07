package com.example.electronicdevicesservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name="device")
public class DeviceEntity {
    @Id
    @SequenceGenerator(name="deviceSequence", sequenceName="device_sequence", allocationSize = 1,initialValue =11)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="deviceSequence")
    @Column(name = "id")
    private Long id;

    @Column(name="date_release")
    private LocalDate dateofRelease;

    @Column(name="supervisior")
    private String supervisor;
    @ManyToOne
    @JoinColumn(name="factory_id")
    private FactoryEntity  factoryId;

}
