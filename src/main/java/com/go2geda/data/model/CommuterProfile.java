package com.go2geda.data.model;


import jakarta.persistence.*;

@Entity
@Table(name = "CommuterProfileTable")
public class CommuterProfile{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Profile profile;



}
