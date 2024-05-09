package com.gprogrammers.rem.services;

import com.gprogrammers.rem.models.PropertyModel;
import com.gprogrammers.rem.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PropertyService {
    @Autowired

    private PropertyRepository propertyRepository;
    public List<PropertyModel> getAllproperty(){
        return propertyRepository.findAll();
    }

    public Optional<PropertyModel> getpropertyById(String id){
        return propertyRepository.findById(id);
    }

    public boolean insertproperty(PropertyModel property){

        try{
            PropertyRepository.insert(property);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAgentById(String id, PropertyModel agent){
        try{
            Optional<PropertyModel> originalproperty= propertyRepository.findById(id);
            if(originalproperty==null){
                return false;
            }

            String location = agent.getLocation();

            if(location != null){
                originalproperty.setLocation(Location);
            }


            String name = agent.getName();

            if(name != null){
                originalpropertysetName(name);
            }


            String urgencyLevel = agent.getUrgencyLevel();

            if(urgencyLevel != null){
                originalproperty.setUrgencyLevel(urgencyLevel);
            }


            String description = agent.getDescription();

            if(description != null){
                originalproperty.setDescription(Description);
            }


            propertyRepository.save(originalproperty);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
