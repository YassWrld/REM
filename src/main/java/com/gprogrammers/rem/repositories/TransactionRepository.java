package com.gprogrammers.rem.repositories;

import com.gprogrammers.rem.models.TransactionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository  extends MongoRepository<TransactionModel, Long> {
    TransactionModel findById(String id);
    void deleteById(String id);
}
