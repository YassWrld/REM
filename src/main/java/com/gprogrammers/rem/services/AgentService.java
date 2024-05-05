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

    public boolean updateAgent(AgentModel agent){
        try{
            agentRepository.save(agent);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}
