package com.gprogrammers.rem.repositories;

import com.gprogrammers.rem.models.ClientModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<ClientModel, Long> {
    ClientModel findById(String id);

    void deleteById(String id);

    ClientModel findByEmail(String email);


}
