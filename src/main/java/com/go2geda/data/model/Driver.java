package com.go2geda.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Driver extends User {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @OneToOne
   private Fleet fleet;

   @OneToOne
   private DriversProfile profile;

}
