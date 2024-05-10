package com.gprogrammers.rem.controllers;

import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.models.PropertyModel;
import com.gprogrammers.rem.services.PropertyService;
import com.gprogrammers.rem.types.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public @ResponseBody ApiResponse<List<PropertyModel>> mainRoute() {
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
    public @ResponseBody HashMap<String,Object> getProperty(@PathVariable String id) {
        HashMap<String,Object> response=new HashMap<>();
        response.put("message","data");
        response.put("property",propertyService.getPropertyById(id));
        return response;
    }

}
