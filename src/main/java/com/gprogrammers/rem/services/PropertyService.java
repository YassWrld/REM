package com.gprogrammers.rem.services;

import com.gprogrammers.rem.models.PropertyModel;
import com.gprogrammers.rem.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public List<PropertyModel> getAllProperties() {
        try{
        return propertyRepository.findAll();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public PropertyModel getPropertyById(String id) {
        return propertyRepository.findById(id);
    }

    public boolean insertProperty(PropertyModel property) {
        try {
            propertyRepository.insert(property);
            return true;
        } catch (Exception e) {
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


            propertyRepository.save(originalProperty);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
