package com.go2geda.driver.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Fleet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String plateNumber;
    private String color;
    private String picture;
    private Integer numberOfSets;
    private String insuranceDocument;
    private String model;
}
