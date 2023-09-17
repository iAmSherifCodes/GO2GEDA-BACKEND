package com.go2geda.data.model;

import com.go2geda.enums.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Setter
@Getter
public class User {
    @Id
    private String id;
    private  String firstName;
    private String lastName;
    private String  email;
    private String phoneNumber;
    private String password;
    private  Review review;
    private  Profile profile;
    private List<Trip>trips;
    private Wallet wallet;
    private Role role;


}
