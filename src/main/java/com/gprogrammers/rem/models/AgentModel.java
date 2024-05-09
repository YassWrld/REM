package com.gprogrammers.rem.models;


import com.gprogrammers.rem.types.User;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "agents")
public class AgentModel extends User {

}
