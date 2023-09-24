package com.go2geda.user.service;

import com.go2geda.commuter.data.model.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripService {
    List<Trip> trips(String from, String to);
}
