package com.gprogrammers.rem.controllers;

import com.gprogrammers.rem.models.ClientModel;
import com.gprogrammers.rem.services.ClientService;
import com.gprogrammers.rem.types.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    public ClientService clientService;

    @GetMapping

    public @ResponseBody List<ClientModel> mainRoute() {
        return clientService.getAllClients();
    }

    @PostMapping
    public @ResponseBody ApiResponse<Object> insertClient(@RequestBody ClientModel client) {
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = clientService.insertClient(client);
        response.setMessage(success ? "Client inserted" : "Client not inserted");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }

    @GetMapping("/{id}")
    public @ResponseBody HashMap<String,Object> getClient(@PathVariable String id) {
        HashMap<String,Object> response=new HashMap<>();
        response.put("message","data");
        response.put("client",clientService.getClientById(id));
        return response;
    }
    @PutMapping("/{id}")
    public @ResponseBody String updateClient(@PathVariable String id, @RequestBody ClientModel client) {
        return clientService.updateClientById(id, client) ? "Client updated" : "Client not updated";
    }


}