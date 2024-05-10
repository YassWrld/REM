package com.gprogrammers.rem.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data

public class VisitModel {

    @Id
    private String id;
    private String clientId;
    private String agentId;
    private String visitDate;
    private String propertyId;

    public boolean addVisit(VisitModel visit) {
        return true;
    }

    public boolean updateVisit(VisitModel visit) {
        return true;
    }

    public boolean deleteVisit(VisitModel visit) {
        return true;
    }


    public String getName() {
            return null;
    }
    public void setName(String name) {
    }



}
