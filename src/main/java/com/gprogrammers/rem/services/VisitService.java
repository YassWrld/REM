package com.gprogrammers.rem.services;


import com.gprogrammers.rem.models.VisitModel;
import com.gprogrammers.rem.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;


    public List<VisitModel> getAllVisits(){
        return visitRepository.findAll();
    }

    public VisitModel getVisitById(String id){
        return visitRepository.findById(id);
    }



    public boolean insertVisit(VisitModel visit){

        try{
            visitRepository.insert(visit);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateVisitById(String id, VisitModel visit){
        try{
            VisitModel originalVisit=visitRepository.findById(id);
            if(originalVisit==null){
                return false;
            }

            Date date = visit.getDate();

            if(date != null){
                originalVisit.setDate(date);
            }


            String agentId = visit.getAgentId();

            if(agentId != null){
                originalVisit.setAgentId(agentId);
            }


            String clientId = visit.getClientId();

            if(clientId != null){
                originalVisit.setClientId(clientId);
            }


            String propertyId = visit.getPropertyId();

            if(propertyId != null){
                originalVisit.setPropertyId(propertyId);
            }

            visitRepository.save(originalVisit);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteVisitById(String id){
        try{
            visitRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}
