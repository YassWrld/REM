package com.gprogrammers.rem.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Data
public abstract class User {
    @MongoId
    protected String id;

    @Indexed(unique = true)
    protected String email;

    protected String name;

    protected String phone;
}
