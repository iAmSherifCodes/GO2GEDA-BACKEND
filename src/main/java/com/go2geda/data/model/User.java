package com.go2geda.data.model;

import com.go2geda.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name= "Go2GedaUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private BasicInformation basicInformation;
    @OneToMany
    private List<Review> reviews;
    @OneToMany
    private List<Trip>trips;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String profilePicture;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Wallet wallet;
    @Enumerated(EnumType.STRING)
    private Role role;

}
