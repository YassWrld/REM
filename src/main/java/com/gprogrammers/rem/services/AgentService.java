package com.gprogrammers.rem.services;


import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.models.PropertyModel;
import com.gprogrammers.rem.repositories.AgentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AgentService {

    private final AgentRepository agentRepository;
    private final PropertyService propertyService;


    public List<AgentModel> getAllAgents() {
        return agentRepository.findAll();
    }

    public AgentModel getAgentById(String id) {
        return agentRepository.findById(id);
    }

    public AgentModel getAgentByEmail(String email) {
        return agentRepository.findByEmail(email);
    }

    public boolean insertAgent(AgentModel agent) {

        try {
            agentRepository.insert(agent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAgentById(String id, AgentModel agent) {
        try {
            AgentModel originalAgent = agentRepository.findById(id);
            if (originalAgent == null) {
                return false;
            }

            String email = agent.getEmail();

            if (email != null) {
                originalAgent.setEmail(email);
            }


            String name = agent.getName();

            if (name != null) {
                originalAgent.setName(name);
            }


            String phone = agent.getPhone();

            if (phone != null) {
                originalAgent.setPhone(phone);
            }


            String password = agent.getPassword();

            if (password != null) {
                originalAgent.setPassword(password);
            }


            boolean isSupervisor = agent.isSupervisor();


            originalAgent.setSupervisor(isSupervisor);


            agentRepository.save(originalAgent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteAgentById(String id) {
        try {
            agentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<AgentModel> getTopAgents() {
        List<PropertyModel> properties = propertyService.getAllProperties();
        List<AgentModel> agents = agentRepository.findAll();

        agents.sort(
                (a, b) -> {
                    int aCount = 0;
                    int bCount = 0;
                    for (PropertyModel property : properties) {
                        if (property.getAgentId().equals(a.getId())) {
                            aCount++;
                        } else if (property.getAgentId().equals(b.getId())) {
                            bCount++;
                        }
                    }
                    return bCount - aCount;
                });

        return agents.subList(0, Math.min(agents.size(), 5));


    }


}
