package com.go2geda.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CommuterProfile extends Profile{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
