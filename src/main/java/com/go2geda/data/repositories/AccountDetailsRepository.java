package com.go2geda.data.repositories;

import com.go2geda.data.model.AccountDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountDetailsRepository extends MongoRepository<AccountDetails,String> {
}
