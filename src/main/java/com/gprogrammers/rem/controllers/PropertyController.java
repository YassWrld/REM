package com.gprogrammers.rem.controllers;

import com.gprogrammers.rem.models.PropertyModel;
import com.gprogrammers.rem.services.PropertyService;
import com.gprogrammers.rem.types.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/property")
@AllArgsConstructor
public class PropertyController {


    private final PropertyService propertyService;


    @GetMapping
    public @ResponseBody ApiResponse<List<PropertyModel>> getAllProperties() {
        ApiResponse<List<PropertyModel>> response = new ApiResponse<>();
        List<PropertyModel> properties = propertyService.getAllProperties();
        boolean success = properties != null;
        response.setMessage(success ? "Properties found" : "Properties not found");
        response.setSuccess(success);
        response.setData(properties);
        return response;
    }

    @PostMapping
    public @ResponseBody ApiResponse<Object> insertProperty(@RequestBody PropertyModel property) {
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = propertyService.insertProperty(property);
        response.setMessage(success ? "Property inserted" : "Property not inserted");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }


    @GetMapping("/{id}")
    public @ResponseBody ApiResponse<PropertyModel> getProperty(@PathVariable String id) {
        ApiResponse<PropertyModel> response = new ApiResponse<>();
        PropertyModel property = propertyService.getPropertyById(id);
        boolean success = property != null;
        response.setMessage(success ? "Property found" : "Property not found");
        response.setData(property);
        response.setSuccess(success);
        return response;
    }

    @PutMapping("/{id}")
    public @ResponseBody ApiResponse<Object> updateProperty(@PathVariable String id, @RequestBody PropertyModel property) {
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = propertyService.updatePropertyById(id, property);
        response.setMessage(success ? "Property updated" : "Property not updated");
        response.setData(null);
        return response;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ApiResponse<Object> deleteProperty(@PathVariable String id) {
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = propertyService.deletePropertyById(id);
        response.setMessage(success ? "Property deleted" : "Property not deleted");
        response.setData(null);
        return response;
    }

    @PostMapping("/{id}/assign/client")
    public @ResponseBody ApiResponse<Object> assignClient(@PathVariable String id, @RequestBody HashMap<String, String> body) {
        ApiResponse<Object> response = new ApiResponse<>();
        String clientId = body.get("clientId");
        boolean success = propertyService.assignPropertyToClient(id, clientId);
        response.setMessage(success ? "Client assigned" : "Client not assigned");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }

    @PostMapping("/{id}/assign/agent")
    public @ResponseBody ApiResponse<Object> assignAgent(@PathVariable String id, @RequestBody HashMap<String, String> body) {
        ApiResponse<Object> response = new ApiResponse<>();
        String agentId = body.get("agentId");
        boolean success = propertyService.assignPropertyToAgent(id, agentId);
        response.setMessage(success ? "Agent assigned" : "Agent not assigned");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }


    @PostMapping("/{id}/confirm")
    public @ResponseBody ApiResponse<Object> confirmProperty(@PathVariable String id) {
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = propertyService.confirmProperty(id);
        response.setMessage(success ? "Property confirmed" : "Property not confirmed");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }


}
