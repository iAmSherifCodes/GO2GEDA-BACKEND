package com.go2geda.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Profile {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;

 @OneToOne(cascade = CascadeType.PERSIST)
 private Address address;

 private String profilePicture;
}
