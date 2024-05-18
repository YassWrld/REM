package com.gprogrammers.rem.services;

import com.gprogrammers.rem.models.ContractModel;
import com.gprogrammers.rem.repositories.ContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;


    public List<ContractModel> getAllContracts() {
        return contractRepository.findAll();
    }

    public ContractModel getContractById(String id) {
        return contractRepository.findById(id);
    }

    public boolean insertContract(ContractModel contract) {
        try {
            contractRepository.insert(contract);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateContractById(String id, ContractModel contract) {
        try {
            ContractModel originalContract = contractRepository.findById(id);

            if (originalContract == null) {
                return false;
            }

            String clientId = contract.getClientId();

            if (clientId != null) {
                originalContract.setClientId(clientId);
            }

            String propertyId = contract.getPropertyId();

            if (propertyId != null) {
                originalContract.setPropertyId(propertyId);
            }

            String notaryName = contract.getNotaryName();

            if (notaryName != null) {
                originalContract.setNotaryName(notaryName);
            }

            float agencyFees = contract.getAgencyFees();

            if (agencyFees != 0) {
                originalContract.setAgencyFees(agencyFees);
            }

            long finalPrice = contract.getFinalPrice();

            if (finalPrice != 0) {
                originalContract.setFinalPrice(finalPrice);
            }

            boolean feesOnClient = contract.isFeesOnClient();


            originalContract.setFeesOnClient(feesOnClient);


            contractRepository.save(originalContract);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteContractById(String id) {
        try {
            contractRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
