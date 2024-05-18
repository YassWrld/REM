package com.gprogrammers.rem.services;

import com.gprogrammers.rem.models.TransactionModel;
import com.gprogrammers.rem.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    public List<TransactionModel> getAllTransactions() {return transactionRepository.findAll();}
    public TransactionModel getTransactionById(String id) {return transactionRepository.findById(id);}

    public boolean insertTransaction(TransactionModel transaction) {
        try {
            transactionRepository.insert(transaction);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTransactionById(String id,TransactionModel transaction) {
        try {
            TransactionModel originalTransacation = transactionRepository.findById(id);

            if (originalTransacation == null) {
                return false;
            }

            String contractId = transaction.getContractId();

            if (contractId == null) {
                originalTransacation.setContractId(id);
            }

            Date date = transaction.getDate();

            if (date == null) {
                originalTransacation.setDate(date);
            }

            transactionRepository.save(originalTransacation);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTransactionById(String id){
        try{
            transactionRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
