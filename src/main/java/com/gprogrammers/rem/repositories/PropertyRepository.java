package com.gprogrammers.rem.repositories;

import com.gprogrammers.rem.models.PropertyModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends MongoRepository<PropertyModel, String> {
    PropertyModel findAgentModelById(String id);
}