package com.go2geda.data.repositories;

import com.go2geda.data.model.DriverLicence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverLicenseRepository extends MongoRepository<DriverLicence,String> {
}
