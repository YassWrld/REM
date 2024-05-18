package com.gprogrammers.rem.controllers;


import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.services.AuthService;
import com.gprogrammers.rem.types.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");


        ApiResponse<String> response = new ApiResponse<>();
        String token = authService.authenticate(email, password);
        boolean success = token != null;
        response.setMessage(success ? "Login successful" : "Login failed")
                .setSuccess(success)
                .setData(token);
        return response;
    }

    @GetMapping("/me")
    public ApiResponse<AgentModel> me(@RequestAttribute("authid") String authId) {
        ApiResponse<AgentModel> response = new ApiResponse<>();
        AgentModel agent = authService.getAgent(authId);

        boolean success = agent != null;

        response
                .setMessage(success ? "You are logged in" : "You are not logged in")
                .setData(agent)
                .setSuccess(success);


        return response;

    }


}
