package com.gprogrammers.rem.controllers;


import com.gprogrammers.rem.types.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import com.gprogrammers.rem.services.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");


        ApiResponse<String> response = new ApiResponse<>();
        String token = authService.authenticate(email, password);
        boolean success = token != null;
        response.setMessage(success ? "Login successful" : "Login failed");
        response.setSuccess(success);
        response.setData(token);
        return response;
    }
    @GetMapping("/me")
    public ApiResponse<AgentModel> me(@Request){
        ApiResponse<AgentModel> response = new ApiResponse<>();
        AgentModel agent = authService.getAgent(authId);

        boolean success = agent != null;

        response.setMessage(success ? "You are logged in" : "You are not logged in");


        response.setData(agent);

        response.setData(authService.getAgent());
        response.setSuccess(success);
        response.setMessage("Agent found");


        return response;

    }


}
