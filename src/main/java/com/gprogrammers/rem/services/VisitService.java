package com.gprogrammers.rem.services;

import com.gprogrammers.rem.models.VisitModel;
import com.gprogrammers.rem.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public List<VisitModel> getAllVisits(){
        return visitRepository.findAll();

    }

    public Optional<VisitModel> getVisitById(String id){
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
            Optional<VisitModel> originalVisit=visitRepository.findById(id);
            if(originalVisit.isEmpty()){
                return false;
            }
            String name = visit.getName();
            if(name != null){
                originalVisit.get().setName(name);
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



