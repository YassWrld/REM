package com.gprogrammers.rem.models;


import com.mongodb.lang.NonNull;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "agents")
@Data
public class AgentModel {
    @MongoId
    private String id;

    @NonNull
    private String name;

    @NonNull
    @Indexed(unique = true)
    private String email;

    @NonNull
    @Indexed(unique = true)
    private String phone;

}
