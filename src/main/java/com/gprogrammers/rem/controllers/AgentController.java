package com.gprogrammers.rem.controllers;

import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.services.AgentService;
import com.gprogrammers.rem.types.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/agent")
@AllArgsConstructor
public class AgentController {

    private final AgentService agentService;


    @GetMapping
    public @ResponseBody ApiResponse<List<AgentModel>> getAllAgents() {

        ApiResponse<List<AgentModel>> response = new ApiResponse<>();
        List<AgentModel> agents = agentService.getAllAgents();
        boolean success = agents != null;
        response
                .setMessage(success ? "Agents found" : "Agents not found")
                .setSuccess(success)
                .setData(agents);
        return response;

    }

    @PostMapping
    public @ResponseBody ApiResponse<Object> insertAgent(@RequestBody AgentModel agent) {
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = agentService.insertAgent(agent);
        response.setMessage(success ? "Agent inserted" : "Agent not inserted")
                .setSuccess(success)
                .setData(null);
        return response;
    }

    @GetMapping("/{id}")
    public @ResponseBody ApiResponse<AgentModel> getAgent(@PathVariable String id) {
        ApiResponse<AgentModel> response = new ApiResponse<>();

        AgentModel agent = agentService.getAgentById(id);
        boolean success = agent != null;
        response.setMessage(success ? "Agent found" : "Agent not found")
                .setData(agent)
                .setSuccess(success);
        return response;
    }

    @PutMapping("/{id}")
    public @ResponseBody ApiResponse<Object> updateAgent(@PathVariable String id, @RequestBody AgentModel agent) {
        ApiResponse<Object> response = new ApiResponse<>();

        boolean success = agentService.updateAgentById(id, agent);
        response.setMessage(success ? "Agent updated" : "Agent not updated")
                .setData(null)
                .setSuccess(success);
        return response;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ApiResponse<Object> deleteAgent(@PathVariable String id) {
        ApiResponse<Object> response = new ApiResponse<>();

        boolean success = agentService.deleteAgentById(id);
        response.setMessage(success ? "Agent deleted" : "Agent not deleted")
                .setData(null)
                .setSuccess(success);
        return response;
    }


    @GetMapping("/top")
    public @ResponseBody ApiResponse<List<AgentModel>> getTopAgents() {
        ApiResponse<List<AgentModel>> response = new ApiResponse<>();
        List<AgentModel> agents = agentService.getTopAgents();
        boolean success = agents != null;
        response.setMessage(success ? "Top Agents found" : "Top Agents not found")
                .setSuccess(success)
                .setData(agents);
        return response;
    }


}
