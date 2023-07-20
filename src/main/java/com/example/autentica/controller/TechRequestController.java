package com.example.autentica.controller;

import com.example.autentica.entity.TechRequest;
import com.example.autentica.service.TechRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechRequestController {

    @Autowired
    private TechRequestService techRequestService;

    @RequestMapping(value = "createtechrequest", method = RequestMethod.POST)
    public String createTechRequest(@RequestBody TechRequest techRequest){
        return techRequestService.createTechRequest(techRequest);
    }

    @RequestMapping(value = "accepttechrequest/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String acceptTechRequest(@PathVariable("id") int id){
        return techRequestService.acceptTechRequest(id);
    }

    @RequestMapping(value = "declinetechrequest/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String declineTechRequest(@PathVariable("id") int id){
        return techRequestService.declineTechRequest(id);
    }

    @RequestMapping(value = "deletetechrequest/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTechRequest(@PathVariable("id") int id){
        return techRequestService.deleteTechRequest(id);
    }

    @RequestMapping(value = "readtechrequests", method = RequestMethod.GET)
    public List<TechRequest> readTechRequests(){
        return techRequestService.readTechRequests();
    }
}
