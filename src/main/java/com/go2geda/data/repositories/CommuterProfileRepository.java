package com.go2geda.data.repositories;

import com.go2geda.data.model.CommuterProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommuterProfileRepository extends MongoRepository<CommuterProfile,String> {
}
