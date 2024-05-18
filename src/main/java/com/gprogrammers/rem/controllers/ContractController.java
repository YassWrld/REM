package com.gprogrammers.rem.controllers;
import com.gprogrammers.rem.models.ContractModel;
import com.gprogrammers.rem.services.ContractService;
import com.gprogrammers.rem.types.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping
    public @ResponseBody ApiResponse<List<ContractModel>> getAllContracts() {

        ApiResponse<List<ContractModel>> response = new ApiResponse<>();
        List<ContractModel> contracts = contractService.getAllContracts();
        boolean success = contracts != null;
        response.setMessage(success ? "Contracts found" : "Contracts not found");
        response.setSuccess(success);
        response.setData(contracts);
        return response;

    }

    @PostMapping
    public @ResponseBody ApiResponse<Object> insertContract(@RequestBody ContractModel contract){
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = contractService.insertContract(contract);
        response.setMessage(success ? "Contract inserted" : "Contract not inserted");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }

    @GetMapping("/{id}")
    public @ResponseBody ApiResponse<ContractModel> getContract(@PathVariable String id) {
        ApiResponse<ContractModel> response = new ApiResponse<>();

        ContractModel contract = contractService.getContractById(id);
        boolean success = contract != null;
        response.setMessage(success ? "Contract found" : "Contract not found");
        response.setData(contract);
        response.setSuccess(success);
        return response;
    }
    @PutMapping("/{id}")
    public @ResponseBody ApiResponse<Object> updateContract(@PathVariable String id, @RequestBody ContractModel contract) {
        ApiResponse<Object> response = new ApiResponse<>();

        boolean success = contractService.updateContractById(id, contract);
        response.setMessage(success ? "Contract updated" : "Contract not updated");
        response.setData(null);
        response.setSuccess(success);
        return response;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ApiResponse<Object> deleteContract(@PathVariable String id) {
        ApiResponse<Object> response = new ApiResponse<>();

        boolean success = contractService.deleteContractById(id);
        response.setMessage(success ? "Contract deleted" : "Contract not deleted");
        response.setData(null);
        response.setSuccess(success);
        return response;
    }
}
