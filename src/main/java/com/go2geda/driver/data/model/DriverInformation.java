package com.go2geda.driver.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DriverProfileTable")
public class DriverInformation {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 @OneToOne(cascade = CascadeType.ALL)
 private DriverLicence driverLicence;
 @OneToOne(cascade = CascadeType.ALL)
 private AccountDetails accountDetails;

}
