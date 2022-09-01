package com.example.b_consumer.repo;

import com.example.b_consumer.model.MessageModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDBRepository extends MongoRepository<MessageModel, String> {
}
