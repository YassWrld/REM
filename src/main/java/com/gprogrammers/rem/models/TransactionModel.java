package com.gprogrammers.rem.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;


@Document(collection = "transactions")
@Data
public class TransactionModel {
    @MongoId
    private String id;
    private String contractId;
    private Date date;
}
