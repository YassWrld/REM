package com.gprogrammers.rem.models;


import com.gprogrammers.rem.types.Location;
import com.gprogrammers.rem.types.enums.ContractType;
import com.gprogrammers.rem.types.enums.PropertyStatus;
import com.gprogrammers.rem.types.enums.PropertyType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "properties")
@Data
public class PropertyModel {
    @MongoId
    private String id;
    private PropertyType type;
    private String title;
    private String description;
    private float area;
    private Location location;
    private PropertyStatus status;
    private long price;
    private ContractType contractType = null;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;
    private String[] media;
    private String clientId = null;
    private String agentId = null;
}
