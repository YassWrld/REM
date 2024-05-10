package com.gprogrammers.rem.repositories;

import com.gprogrammers.rem.models.VisitModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface VisitRepository extends MongoRepository<VisitModel, String> {


    Optional<VisitModel> findById (String id);




}
