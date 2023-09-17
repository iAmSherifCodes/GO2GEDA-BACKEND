package com.go2geda.data.repositories;

import com.go2geda.data.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<Chat,String> {
}
