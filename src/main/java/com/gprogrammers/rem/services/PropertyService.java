package com.gprogrammers.rem.services;


import com.gprogrammers.rem.models.PropertyModel;
import com.gprogrammers.rem.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class PropertyService {

    @Autowired

    private PropertyRepository propertyRepository;

    public List<PropertyModel> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Object getPropertyById(String id) {
        return propertyRepository.findById(id);
    }

    public boolean insertProperty(PropertyModel property) {
        try {
            propertyRepository.insert(property);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePropertyById(String id, PropertyModel property) {
        try {
            PropertyModel originalProperty = propertyRepository.findById(id);
            if (originalProperty == null) {
                return false;
            }


            String name = property.getName();

            if(name != null) {
                originalProperty.setName(name);
            }

            String location = property.getLocation();

            if (location != null) {
                originalProperty.setLocation(location);
            }

            String UrgencyLevel = property.getUrgencyLevel();

            if (UrgencyLevel != null) {
                originalProperty.setUrgencyLevel(UrgencyLevel);
            }

            String Description = property.getDescription();

            if (Description != null) {
                originalProperty.setDescription(Description);
            }

            PropertyModel.save(originalProperty);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
