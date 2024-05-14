package com.gprogrammers.rem.controllers;


import com.gprogrammers.rem.types.ApiResponse;
import com.gprogrammers.rem.types.State;
import com.gprogrammers.rem.utils.StatesReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gprogrammers.rem.services.AuthService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private AuthService authService;
@GetMapping("/states")
public @ResponseBody ApiResponse<List<State>> getStates() {
    ApiResponse<List<State>> response = new ApiResponse<>();
    List<State> states = StatesReader.getAllStates();
    boolean success = states != null;
    response.setMessage(success ? "States found" : "States not found");
    response.setSuccess(success);
    response.setData(states);
    return response;
}

@RequestMapping("/upload")
public @ResponseBody ApiResponse<Map<String, Object>> upload(@RequestParam("file") MultipartFile file) {
    ApiResponse<Map<String, Object>> response = new ApiResponse<>();
    String path = authService.upload(file);
    boolean success = path != null;
    response.setMessage(success ? "File uploaded" : "File not uploaded");
    response.setSuccess(success);
    response.setData(Map.of("path", path));
    return response;
}

}
