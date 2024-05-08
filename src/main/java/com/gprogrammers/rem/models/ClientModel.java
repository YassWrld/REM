package com.gprogrammers.rem.models;


import com.gprogrammers.rem.types.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "clients")
@Data
public class ClientModel extends User {


    protected String clientType;
    protected double minBudget;
    protected double maxBudget;
    protected String propertyPreferences;
    protected String locationPreferences;

    public void printUserInfo() {
        System.out.println("User ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Password: " + password);
        //example about other attributes from User class
    }


}