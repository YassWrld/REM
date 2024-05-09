package com.gprogrammers.rem.models;

import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@EqualsAndHashCode
@Document(collection = "propertys")
public class PropertyModel {
    @MongoId
    public String id;
    public String Name;
    public String Location ;
    public String UrgencyLevel ;
    public String Description ;
}
