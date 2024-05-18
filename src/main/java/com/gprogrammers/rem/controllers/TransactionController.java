package com.gprogrammers.rem.controllers;

import com.gprogrammers.rem.models.TransactionModel;
import com.gprogrammers.rem.services.TransactionService;
import com.gprogrammers.rem.types.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public @ResponseBody ApiResponse<List<TransactionModel>> getAllTransactions() {

        ApiResponse<List<TransactionModel>> response = new ApiResponse<>();
        List<TransactionModel> transactions = transactionService.getAllTransactions();
        boolean success = transactions != null;
        response.setMessage(success ? "Transactions found" : "Transactions not found");
        response.setSuccess(success);
        response.setData(transactions);
        return response;

    }

    @PostMapping
    public @ResponseBody ApiResponse<Object> insertTransaction(@RequestBody TransactionModel transaction) {
        ApiResponse<Object> response = new ApiResponse<>();
        boolean success = transactionService.insertTransaction(transaction);
        response.setMessage(success ? "Transaction inserted" : "Transaction not inserted");
        response.setSuccess(success);
        response.setData(null);
        return response;
    }

    @GetMapping("/{id}")
    public @ResponseBody ApiResponse<TransactionModel> getTransaction(@PathVariable String id) {
        ApiResponse<TransactionModel> response = new ApiResponse<>();

        TransactionModel transaction = transactionService.getTransactionById(id);
        boolean success = transaction != null;
        response.setMessage(success ? "Transaction found" : "Transaction not found");
        response.setData(transaction);
        response.setSuccess(success);
        return response;
    }

    @PutMapping("/{id}")
    public @ResponseBody ApiResponse<Object> updateTransaction(@PathVariable String id, @RequestBody TransactionModel transaction) {
        ApiResponse<Object> response = new ApiResponse<>();

        boolean success = transactionService.updateTransactionById(id, transaction);
        response.setMessage(success ? "Transaction updated" : "Transaction not updated");
        response.setData(null);
        response.setSuccess(success);
        return response;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ApiResponse<Object> deleteTransaction(@PathVariable String id) {
        ApiResponse<Object> response = new ApiResponse<>();

        boolean success = transactionService.deleteTransactionById(id);
        response.setMessage(success ? "Transaction deleted" : "Transaction not deleted");
        response.setData(null);
        response.setSuccess(success);
        return response;
    }
}
