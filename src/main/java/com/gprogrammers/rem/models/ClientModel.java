package com.gprogrammers.rem.models;

import com.gprogrammers.rem.types.Location;
import com.gprogrammers.rem.types.User;
import com.gprogrammers.rem.types.enums.ContractType;
import com.gprogrammers.rem.types.enums.PropertyType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
@EqualsAndHashCode(callSuper = true)

@Document(collection = "clients")
@Data
public class ClientModel extends User {
    private float budget;
    private PropertyType propertyType;
    private Location location;
    private ContractType contractType;
}
