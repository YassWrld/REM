package com.gprogrammers.rem.controllers;
import com.gprogrammers.rem.models.ClientModel;
import com.gprogrammers.rem.services.ClientService;
import com.gprogrammers.rem.types.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public @ResponseBody ApiResponse<List<ClientModel>> getAllClients() {

        ApiResponse<List<ClientModel>> response = new ApiResponse<>();
        List<ClientModel> clients = clientService.getAllClients();
        boolean success = clients != null;
        response.setMessage(success ? "Clients found" : "Clients not found");
        response.setSuccess(success);
        response.setData(clients);
        return response;

    }

    @PostMapping
    public @ResponseBody ApiResponse<Object> insertClient(@RequestBody ClientModel client){
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = clientService.insertClient(client);
        response.setMessage(success ? "Client inserted" : "Client not inserted");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }

    @GetMapping("/{id}")
    public @ResponseBody ApiResponse<ClientModel> getClient(@PathVariable String id) {
        ApiResponse<ClientModel> response = new ApiResponse<>();

        ClientModel client = clientService.getClientById(id);
        boolean success = client != null;
        response.setMessage(success ? "Client found" : "Client not found");
        response.setData(client);
        response.setSuccess(success);
        return response;
    }
    @PutMapping("/{id}")
    public @ResponseBody ApiResponse<Object> updateClient(@PathVariable String id, @RequestBody ClientModel client) {
        ApiResponse<Object> response = new ApiResponse<>();

        boolean success = clientService.updateClientById(id, client);
        response.setMessage(success ? "Client updated" : "Client not updated");
        response.setData(null);
        response.setSuccess(success);
        return response;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ApiResponse<Object> deleteClient(@PathVariable String id) {
        ApiResponse<Object> response = new ApiResponse<>();

        boolean success = clientService.deleteClientById(id);
        response.setMessage(success ? "Client deleted" : "Client not deleted");
        response.setData(null);
        response.setSuccess(success);
        return response;
    }


}
