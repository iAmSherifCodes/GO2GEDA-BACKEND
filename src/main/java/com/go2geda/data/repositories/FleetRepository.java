package com.go2geda.data.repositories;

import com.go2geda.data.model.Fleet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FleetRepository extends MongoRepository<Fleet,String> {
}
