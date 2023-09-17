package com.go2geda.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document
public class DriversProfile extends Profile {
 private DriverLicence driverLicence;
 private AccountDetails accountDetails;


}
