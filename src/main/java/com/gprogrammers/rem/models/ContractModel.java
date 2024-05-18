package com.gprogrammers.rem.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "contracts")
@Data

public class ContractModel {
    @MongoId
    private String id;
    private String clientId;
    private String propertyId;
    private String notaryName;
    private long finalPrice;
    private float agencyFees; // in %
    private boolean feesOnClient = false; // true for client false for owner
}








