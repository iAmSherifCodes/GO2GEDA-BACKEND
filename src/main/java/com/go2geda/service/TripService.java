package com.go2geda.service;

import com.go2geda.data.model.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripService {
    List<Trip> trips(String from, String to);
}
