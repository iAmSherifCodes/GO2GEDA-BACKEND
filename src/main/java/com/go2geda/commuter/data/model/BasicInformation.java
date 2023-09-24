package com.go2geda.commuter.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name= "UserBasicInformation")
public class BasicInformation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String firstName;
    private String lastName;
    @Column(unique = true)
    private String  email;
    private String phoneNumber;
    private String password;
}
