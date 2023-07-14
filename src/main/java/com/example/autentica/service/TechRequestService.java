package com.example.autentica.service;

import com.example.autentica.entity.TechRequest;
import com.example.autentica.repository.TechRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TechRequestService {

    @Autowired
    private TechRequestRepository studentRepository;

    @Transactional
    public String createStudent(TechRequest techRequest){
        try {
            if (!studentRepository.existsByEmail(techRequest.getEmail())){
                techRequest.setId(null == studentRepository.findMaxId()? 0 : studentRepository.findMaxId() + 1);
                studentRepository.save(techRequest);
                return "TechRequest record created successfully.";
            }else {
                return "TechRequest already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<TechRequest> readStudents(){
        return studentRepository.findAll();
    }

    @Transactional
    public String updateStudent(TechRequest techRequest){
        if (studentRepository.existsByEmail(techRequest.getEmail())){
            try {
                List<TechRequest> techRequests = studentRepository.findByEmail(techRequest.getEmail());
                techRequests.stream().forEach(s -> {
                    TechRequest techRequestToBeUpdate = studentRepository.findById(s.getId()).get();
                    techRequestToBeUpdate.setName(techRequest.getName());
                    techRequestToBeUpdate.setEmail(techRequest.getEmail());
                    studentRepository.save(techRequestToBeUpdate);
                });
                return "TechRequest record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "TechRequest does not exists in the database.";
        }
    }

    @Transactional
    public String deleteStudent(TechRequest techRequest){
        if (studentRepository.existsByEmail(techRequest.getEmail())){
            try {
                List<TechRequest> techRequests = studentRepository.findByEmail(techRequest.getEmail());
                techRequests.stream().forEach(s -> {
                    studentRepository.delete(s);
                });
                return "TechRequest record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "TechRequest does not exist";
        }
    }
}
