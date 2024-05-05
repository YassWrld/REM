package com.gprogrammers.rem.controllers;
import com.gprogrammers.rem.models.AgentModel;
import com.gprogrammers.rem.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")

    public @ResponseBody AgentModel getAgent(@PathVariable String id) {
        return agentService.getAgentById(id);
    }

    @PostMapping
    public @ResponseBody String insertAgent(@RequestBody AgentModel agent) {
        return agentService.insertAgent(agent) ? "Agent inserted" : "Agent not inserted";
    }




}
