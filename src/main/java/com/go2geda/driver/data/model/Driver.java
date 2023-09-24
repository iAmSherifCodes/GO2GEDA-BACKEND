package com.go2geda.driver.data.model;

import com.go2geda.commuter.data.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "DriverTable")
public class Driver{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @OneToOne(cascade = CascadeType.ALL)
   private User user;
   @OneToOne(cascade = CascadeType.ALL)
   private Fleet fleet;
   @OneToOne(cascade = CascadeType.ALL)
   private DriverInformation driverInformation;


}
