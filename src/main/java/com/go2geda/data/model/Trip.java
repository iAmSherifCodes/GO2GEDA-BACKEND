package com.go2geda.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@Document
public class Trip {
    @Id
    private String id;
    private String from;
    private String to;
    private Integer pricePerSeat;
    private Integer numberOfSeatsAvailable;
    private LocalDateTime pickUpTime;
    private LocalDateTime endTime;
    private LocalDateTime startTime;
}
