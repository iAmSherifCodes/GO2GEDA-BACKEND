package com.go2geda.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DriverProfileTable")
public class DriversProfile{
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;

 @OneToOne
 private Profile profile;
 @OneToOne
 private DriverLicence driverLicence;
 @OneToOne
 private AccountDetails accountDetails;

}
