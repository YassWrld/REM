package com.gprogrammers.rem.services;

import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AgentService agentService;

    @Autowired
    private JWTUtil jwtUtil;

    public String authenticate(String email, String password){
        AgentModel agent = agentService.getAgentByEmail(email);
        if (agent == null){
            return null;
        }

        boolean isAuthenticated = agent.getPassword().equals(password);

        if (isAuthenticated){
            return jwtUtil.generateToken(agent.getId());
        }

        return null;
    }




}
