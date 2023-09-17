package com.go2geda.data.repositories;

import com.go2geda.data.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver,String> {
}
