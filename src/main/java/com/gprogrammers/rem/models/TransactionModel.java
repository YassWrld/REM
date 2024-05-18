package com.gprogrammers.rem.models;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;


@Document(collection = "transactions")
@Data
public class TransactionModel {
    @MongoId
    private String id;
    private String contractId;
    private Date date;
}
