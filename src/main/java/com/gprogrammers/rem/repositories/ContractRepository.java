package com.gprogrammers.rem.repositories;

import com.gprogrammers.rem.models.ContractModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractRepository extends MongoRepository<ContractModel, Long> {
    ContractModel findById(String id);

    void deleteById(String id);
}
