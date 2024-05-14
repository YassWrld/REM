package com.gprogrammers.rem.services;


import com.gprogrammers.rem.models.ClientModel;
import com.gprogrammers.rem.repositories.ClientRepository;
import com.gprogrammers.rem.types.Location;
import com.gprogrammers.rem.types.enums.ContractType;
import com.gprogrammers.rem.types.enums.PropertyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    public List<ClientModel> getAllClients() {
        return clientRepository.findAll();
    }

    public ClientModel getClientById(String id) {
        return clientRepository.findById(id);
    }

    public ClientModel getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public boolean insertClient(ClientModel client) {

        try {
            clientRepository.insert(client);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateClientById(String id, ClientModel client) {
        try {
            ClientModel originalClient = clientRepository.findById(id);
            if (originalClient == null) {
                return false;
            }

            String email = client.getEmail();

            if (email != null) {
                originalClient.setEmail(email);
            }


            String name = client.getName();

            if (name != null) {
                originalClient.setName(name);
            }


            String phone = client.getPhone();

            if (phone != null) {
                originalClient.setPhone(phone);
            }


            Location location = client.getLocation();

            if (location != null) {
                originalClient.setLocation(location);
            }


            float budget = client.getBudget();


            if (budget > 0) {
                originalClient.setBudget(budget);
            }


            PropertyType propertyType = client.getPropertyType();

            if (propertyType != null) {
                originalClient.setPropertyType(propertyType);
            }


            ContractType contractType = client.getContractType();

            if (contractType != null) {
                originalClient.setContractType(contractType);
            }


            clientRepository.save(originalClient);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteClientById(String id) {
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




}
