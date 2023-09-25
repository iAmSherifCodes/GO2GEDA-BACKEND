package com.go2geda.user.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;
    private String from;
    private String to;
    private Integer pricePerSeat;
    private Integer numberOfSeatsAvailable;
    private LocalDateTime pickUpTime;
    private LocalDateTime endTime;
    private LocalDateTime startTime;
}
