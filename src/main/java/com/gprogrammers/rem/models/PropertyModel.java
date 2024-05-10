package com.gprogrammers.rem.models;


import com.gprogrammers.rem.types.Location;
import com.gprogrammers.rem.types.enums.ContractType;
import com.gprogrammers.rem.types.enums.PropertyStatus;
import com.gprogrammers.rem.types.enums.PropertyType;
import lombok.Data;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "property")
@Data
public class PropertyModel {
    @MongoId
    private String id;
    private String title;
    private Location location;
    private PropertyType type;
    private float area;
    private PropertyStatus status;
    private int price;
    private String description;
    private ContractType contractType = null;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;
    private String[] images;
    private String clientId;
    private String agentId;
}
