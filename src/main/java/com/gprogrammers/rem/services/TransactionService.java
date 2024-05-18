package com.gprogrammers.rem.services;

import com.gprogrammers.rem.models.TransactionModel;
import com.gprogrammers.rem.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;


    public List<TransactionModel> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public TransactionModel getTransactionById(String id) {
        return transactionRepository.findById(id);
    }

    public boolean insertTransaction(TransactionModel transaction) {
        try {
            transactionRepository.insert(transaction);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTransactionById(String id, TransactionModel transaction) {
        try {
            TransactionModel originalTransaction = transactionRepository.findById(id);

            if (originalTransaction == null) {
                return false;
            }

            String contractId = transaction.getContractId();

            if (contractId == null) {
                originalTransaction.setContractId(id);
            }

            Date date = transaction.getDate();

            if (date == null) {
                originalTransaction.setDate(date);
            }

            transactionRepository.save(originalTransaction);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTransactionById(String id) {
        try {
            transactionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
