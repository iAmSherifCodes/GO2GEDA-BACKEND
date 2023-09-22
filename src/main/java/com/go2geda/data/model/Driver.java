package com.go2geda.data.model;

import com.go2geda.enums.Role;
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
   @OneToOne
   private User user;
   @OneToOne
   private Fleet fleet;
   @OneToOne
   private DriversProfile profile;


}
