package com.gprogrammers.rem.controllers;

import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.services.PropertyService;
import com.gprogrammers.rem.types.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    public PropertyService propertyService;



    @GetMapping
    public @ResponseBody List<PropertyModel> mainRoute() {
        return propertyService.getAllProperties();
    }

    @PostMapping
    public @ResponseBody ApiResponse<Object> insertAgent(@RequestBody PropertyModel property) {
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = propertyService.insertProperty(property);
        response.setMessage(success ? "Property inserted" : "Property not inserted");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }

    @GetMapping("/{id}")
    public @ResponseBody HashMap<String,Object> getAgent(@PathVariable String id) {
        HashMap<String,Object> response=new HashMap<>();
        response.put("message","data");
        response.put("property",propertyService.getPropertyById(id));
        return response;
    }
    @PostMapping("/{id}")
    public @ResponseBody String updateAgent(@PathVariable String id, @RequestBody PropertyModel property) {
        return propertyService.updatePropertyById(id, property) ? "Property updated" : "Property not updated";
    }



}
