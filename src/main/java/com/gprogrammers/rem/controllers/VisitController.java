package com.gprogrammers.rem.controllers;

import org.springframework.web.bind.annotation.*;
import com.gprogrammers.rem.models.VisitModel;
import com.gprogrammers.rem.services.VisitService;
import com.gprogrammers.rem.types.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/visit")
@CrossOrigin

public class VisitController {

    @Autowired
    public VisitService visitService;

    @GetMapping
    public @ResponseBody List<VisitModel> mainRoute() {
        return visitService.getAllVisits();
    }

    @PostMapping
    public @ResponseBody ApiResponse<Object> insertVisit(@RequestBody VisitModel visit) {
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = visitService.insertVisit(visit);
        response.setMessage(success ? "Visit inserted" : "Visit not inserted");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }

    @GetMapping("/{id}")
    public @ResponseBody HashMap<String,Object> getVisit(@PathVariable String id) {
        HashMap<String,Object> response=new HashMap<>();
        response.put("message","data");
        response.put("visit",visitService.getVisitById(id));
        return response;
    }
    @PutMapping("/{id}")
    public @ResponseBody String updateVisit(@PathVariable String id, @RequestBody VisitModel visit) {
        return visitService.updateVisitById(id, visit) ? "Visit updated" : "Visit not updated";
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deleteVisit(@PathVariable String id) {
        return visitService.deleteVisitById(id) ? "Visit deleted" : "Visit not deleted";
    }

}
