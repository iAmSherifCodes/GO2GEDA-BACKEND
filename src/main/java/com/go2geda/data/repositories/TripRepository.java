package com.go2geda.data.repositories;

import com.go2geda.data.model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip,String> {
}
