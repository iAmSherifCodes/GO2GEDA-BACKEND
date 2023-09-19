package com.go2geda.data.model;

import com.go2geda.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Driver{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @OneToOne
   private User user;

   @OneToOne
   private Fleet fleet;

//   @Enumerated(EnumType.STRING)
//   private Role role;

   @OneToOne
   private DriversProfile profile;


}
