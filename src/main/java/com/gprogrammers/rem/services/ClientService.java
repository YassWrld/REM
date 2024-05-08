package com.gprogrammers.rem.services;

import com.gprogrammers.rem.models.ClientModel;
import com.gprogrammers.rem.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class   ClientService {

    @Autowired
    private ClientRepository clientRepository;
    public List<ClientModel> getAllClients(){
        return clientRepository.findAll();

    }
    
    public Object getClientById(String id) {
        return clientRepository.findById(id);
    }

    public boolean insertClient(ClientModel client){

        try{
            clientRepository.insert(client);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateClientById(String id, ClientModel client){
        try{
            ClientModel originalClient=clientRepository.findById(id);
            if(originalClient==null){
                return false;
            }

            String email = client.getEmail();

            if(email != null){
                originalClient.setEmail(email);
            }

            String name = client.getName();

            if(name != null){
                originalClient.setName(name);

            }

            String phone = client.getPhone();

            if(phone != null){
                originalClient.setPhone(phone);
            }

            String password = client.getPassword();

            if(password != null){
                originalClient.setPassword(password);
            }

           clientRepository.save(originalClient);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}
