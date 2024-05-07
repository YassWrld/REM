package com.gprogrammers.rem.controllers;
import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.services.AgentService;
import com.gprogrammers.rem.types.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    public AgentService agentService;

    @GetMapping
    public @ResponseBody List<AgentModel> mainRoute() {
        return agentService.getAllAgents();
    }

    @PostMapping
    public @ResponseBody ApiResponse<Object> insertAgent(@RequestBody AgentModel agent) {
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = agentService.insertAgent(agent);
        response.setMessage(success ? "Agent inserted" : "Agent not inserted");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }

    @GetMapping("/{id}")
    public @ResponseBody HashMap<String,Object> getAgent(@PathVariable String id) {
        HashMap<String,Object> response=new HashMap<>();
        response.put("message","data");
        response.put("agent",agentService.getAgentById(id));
        return response;
    }
    @PutMapping("/{id}")
    public @ResponseBody String updateAgent(@PathVariable String id, @RequestBody AgentModel agent) {
        return agentService.updateAgentById(id, agent) ? "Agent updated" : "Agent not updated";
    }

}
