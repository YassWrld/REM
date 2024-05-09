package com.gprogrammers.rem.services;


import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;
    public List<AgentModel> getAllAgents(){
        return agentRepository.findAll();
    }

    public AgentModel getAgentById(String id){
        return agentRepository.findById(id);
    }

    public boolean insertAgent(AgentModel agent){

        try{
            agentRepository.insert(agent);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAgentById(String id, AgentModel agent){
        try{
            AgentModel originalAgent=agentRepository.findById(id);
            if(originalAgent==null){
                return false;
            }

            String email = agent.getEmail();

            if(email != null){
                originalAgent.setEmail(email);
            }


            String name = agent.getName();

            if(name != null){
                originalAgent.setName(name);
            }


            String phone = agent.getPhone();

            if(phone != null){
                originalAgent.setPhone(phone);
            }


            String password = agent.getPassword();

            if(password != null){
                originalAgent.setPassword(password);
            }


            agentRepository.save(originalAgent);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}
