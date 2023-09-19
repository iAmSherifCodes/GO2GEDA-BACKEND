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
    private  String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String  email;
    private String phoneNumber;
    private String password;
    @OneToMany
    private List<Review> reviews;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profile profile;
    @OneToMany
    private List<Trip>trips;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Wallet wallet;

    @Enumerated(EnumType.STRING)
    private Role role;


}
