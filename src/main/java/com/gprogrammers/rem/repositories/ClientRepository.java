package com.gprogrammers.rem.repositories;

import com.gprogrammers.rem.models.ClientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<ClientModel, Long> {
    ClientModel findById(String id);
}
