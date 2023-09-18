package com.go2geda.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DriversProfile extends Profile {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 @OneToOne
 private DriverLicence driverLicence;
 @OneToOne
 private AccountDetails accountDetails;

}
