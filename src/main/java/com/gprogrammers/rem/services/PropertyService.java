package com.gprogrammers.rem.services;

import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.models.ClientModel;
import com.gprogrammers.rem.models.PropertyModel;
import com.gprogrammers.rem.repositories.AgentRepository;
import com.gprogrammers.rem.repositories.ClientRepository;
import com.gprogrammers.rem.repositories.PropertyRepository;
import com.gprogrammers.rem.types.Location;
import com.gprogrammers.rem.types.enums.ContractType;
import com.gprogrammers.rem.types.enums.PropertyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AgentRepository agentRepository;

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


            String title = property.getTitle();
            if (title != null) {
                originalProperty.setTitle(title);
            }

            String description = property.getDescription();
            if (description != null) {
                originalProperty.setDescription(description);
            }

            float area = property.getArea();
            if (area > 0) {
                originalProperty.setArea(area);
            }

            Location location = property.getLocation();
            if (location != null) {
                originalProperty.setLocation(location);
            }

            PropertyStatus status = property.getStatus();
            if (status != null) {
                originalProperty.setStatus(status);
            }

            int price = property.getPrice();
            if (price > 0) {
                originalProperty.setPrice(price);
            }

            ContractType contractType = property.getContractType();
            if (contractType != null) {
                originalProperty.setContractType(contractType);
            }

            String ownerName = property.getOwnerName();
            if (ownerName != null) {
                originalProperty.setOwnerName(ownerName);
            }

            String ownerEmail = property.getOwnerEmail();
            if (ownerEmail != null) {
                originalProperty.setOwnerEmail(ownerEmail);
            }

            String ownerPhone = property.getOwnerPhone();
            if (ownerPhone != null) {
                originalProperty.setOwnerPhone(ownerPhone);
            }

            String[] media = property.getMedia();
            if (media != null) {
                originalProperty.setMedia(media);
            }

            String clientId = property.getClientId();
            if (clientId != null) {
                originalProperty.setClientId(clientId);
            }

            String agentId = property.getAgentId();
            if (agentId != null) {
                originalProperty.setAgentId(agentId);
            }

            propertyRepository.save(originalProperty); // Save the updated property
            return true; // Successfully updated
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Failed to update property
        }
    }



    public boolean deletePropertyById(String id) {
        try {
            PropertyModel originalProperty = propertyRepository.findById(id);
            if (originalProperty == null) {
                return false;
            }

            propertyRepository.delete(originalProperty);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean assignPropertyToClient(String propertyId, String clientId) {
        try {
            PropertyModel property = propertyRepository.findById(propertyId);
            if (property == null) {
                return false;
            }
            ClientModel client = clientRepository.findById(clientId);

            if (client == null) {
                return false;
            }

            property.setClientId(clientId);
            property.setStatus(PropertyStatus.Assigned);

            propertyRepository.save(property);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean assignPropertyToAgent(String propertyId, String agentId) {
        try {
            PropertyModel property = propertyRepository.findById(propertyId);
            if (property == null) {
                return false;
            }
            AgentModel agent = agentRepository.findById(agentId);

            if (agent == null) {
                return false;
            }

            property.setAgentId(agentId);
            property.setStatus(PropertyStatus.Assigned);

            propertyRepository.save(property);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




    public  boolean confirmProperty(String propertyId){
        try{
            PropertyModel property=propertyRepository.findById(propertyId);
            if(property==null){
                return false;
            }
            property.setStatus(PropertyStatus.Confirmed);
            propertyRepository.save(property);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }





}
