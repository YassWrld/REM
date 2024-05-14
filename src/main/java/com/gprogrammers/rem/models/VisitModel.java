package com.gprogrammers.rem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;


@Document(collection = "visits")
@Data
public class VisitModel {
    @MongoId
    private  String id;

    private String propertyId;
    private String clientId;
    private String agentId;

    private Date date;
}
