package com.gprogrammers.rem.repositories;

import com.gprogrammers.rem.models.VisitModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisitRepository extends MongoRepository<VisitModel, Long> {
    VisitModel findById(String id);

    void deleteById(String id);

}
