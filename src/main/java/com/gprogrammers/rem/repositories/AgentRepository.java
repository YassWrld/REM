package com.gprogrammers.rem.repositories;
import com.gprogrammers.rem.models.AgentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface AgentRepository extends MongoRepository<AgentModel, Long> {
    AgentModel findById(String id);


}
