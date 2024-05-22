package com.gprogrammers.rem.services;

import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.utils.JWTUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@Service
@AllArgsConstructor
public class AuthService {

    private final AgentService agentService;


    private final JWTUtil jwtUtil;

    public String authenticate(String email, String password) {
        AgentModel agent = agentService.getAgentByEmail(email);
        if (agent == null) {
            return null;
        }

        boolean isAuthenticated = agent.getPassword().equals(password);

        if (isAuthenticated) {
            return jwtUtil.generateToken(agent.getId());
        }

        return null;
    }


    public AgentModel getAgent(String id) {
        return agentService.getAgentById(id);
    }


    public String upload(MultipartFile file) {

        //save file to /static folder

        File newFile = new File("src/main/resources/static/media/" + file.getOriginalFilename());


        try {
            Files.write(newFile.toPath(), file.getBytes());
            return "media/" + file.getOriginalFilename();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}
