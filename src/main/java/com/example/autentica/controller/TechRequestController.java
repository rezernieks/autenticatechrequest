package com.example.autentica.controller;

import com.example.autentica.entity.TechRequest;
import com.example.autentica.service.TechRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TechRequestController {

    @Autowired
    private TechRequestService techRequestService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "createstudent", method = RequestMethod.POST)
    public String createStudent(@RequestBody TechRequest techRequest){
        return techRequestService.createStudent(techRequest);
    }

    @RequestMapping(value = "readstudents", method = RequestMethod.GET)
    public List<TechRequest> readStudents(){
        return techRequestService.readStudents();
    }

    @RequestMapping(value = "updatestudent", method = RequestMethod.PUT)
    public String updateStudet(@RequestBody TechRequest techRequest){
        return techRequestService.updateStudent(techRequest);
    }

    @RequestMapping(value = "deletestudent", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestBody TechRequest techRequest){
        return techRequestService.deleteStudent(techRequest);
    }
}
