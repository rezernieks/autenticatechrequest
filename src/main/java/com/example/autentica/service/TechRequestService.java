package com.example.autentica.service;

import com.example.autentica.entity.TechRequest;
import com.example.autentica.repository.TechRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TechRequestService {

    @Autowired
    private TechRequestRepository techRequestRepository;

    public List<TechRequest> readTechRequests(){
        return techRequestRepository.findAll();
    }

    @Transactional
    public String createTechRequest(TechRequest techRequest){
        try {
            techRequest.setId(null == techRequestRepository.findMaxId()? 0 : techRequestRepository.findMaxId() + 1);
            LocalDateTime localDateTime = LocalDateTime.now();
            techRequest.setDate(localDateTime.toString());
            techRequestRepository.save(techRequest);
            return "TechRequest record created successfully.";
        }catch (Exception e){
            throw e;
        }
    }

    @Transactional
    public String acceptTechRequest(int Id){
        if (techRequestRepository.existsById(Id)){
            try {
                TechRequest techRequestToBeUpdate = techRequestRepository.findById(Id).get();
                techRequestToBeUpdate.setReviewed(true);
                techRequestToBeUpdate.setStatus(true);
                techRequestRepository.save(techRequestToBeUpdate);
                return "TechRequest record " + Id + " accepted.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "TechRequest " + Id + " does not exists in the database.";
        }
    }

    @Transactional
    public String declineTechRequest(int Id){
        if (techRequestRepository.existsById(Id)){
            try {
                TechRequest techRequestToBeUpdate = techRequestRepository.findById(Id).get();
                techRequestToBeUpdate.setReviewed(true);
                techRequestToBeUpdate.setStatus(false);
                techRequestRepository.save(techRequestToBeUpdate);
                return "TechRequest record " + Id + " declined.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "TechRequest " + Id + " does not exists in the database.";
        }
    }

    @Transactional
    public String deleteTechRequest(int Id){
        if (techRequestRepository.existsById(Id)){
            try {
                techRequestRepository.delete(techRequestRepository.findById(Id).get());
                return "TechRequest record " + Id + " deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "TechRequest " + Id + " does not exist";
        }
    }
}
