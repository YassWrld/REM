package com.gprogrammers.rem.controllers;

import com.gprogrammers.rem.models.VisitModel;
import com.gprogrammers.rem.services.VisitService;
import com.gprogrammers.rem.types.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/visit")
@AllArgsConstructor
public class VisitController {

    private final VisitService visitService;


    @GetMapping
    public @ResponseBody ApiResponse<List<VisitModel>> getAllVisits() {

        ApiResponse<List<VisitModel>> response = new ApiResponse<>();
        List<VisitModel> visits = visitService.getAllVisits();
        boolean success = visits != null;
        response.setMessage(success ? "Visits found" : "Visits not found");
        response.setSuccess(success);
        response.setData(visits);
        return response;

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
    public @ResponseBody ApiResponse<VisitModel> getVisit(@PathVariable String id) {
        ApiResponse<VisitModel> response = new ApiResponse<>();

        VisitModel visit = visitService.getVisitById(id);
        boolean success = visit != null;
        response.setMessage(success ? "Visit found" : "Visit not found");
        response.setData(visit);
        response.setSuccess(success);
        return response;
    }

    @PutMapping("/{id}")
    public @ResponseBody ApiResponse<Object> updateVisit(@PathVariable String id, @RequestBody VisitModel visit) {
        ApiResponse<Object> response = new ApiResponse<>();

        boolean success = visitService.updateVisitById(id, visit);
        response.setMessage(success ? "Visit updated" : "Visit not updated");
        response.setData(null);
        response.setSuccess(success);
        return response;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ApiResponse<Object> deleteVisit(@PathVariable String id) {
        ApiResponse<Object> response = new ApiResponse<>();

        boolean success = visitService.deleteVisitById(id);
        response.setMessage(success ? "Visit deleted" : "Visit not deleted");
        response.setData(null);
        response.setSuccess(success);
        return response;
    }


}
