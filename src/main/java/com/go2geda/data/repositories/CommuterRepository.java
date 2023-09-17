package com.go2geda.data.repositories;

import com.go2geda.data.model.Commuter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommuterRepository extends MongoRepository<Commuter,String> {
}
