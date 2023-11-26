package com.service.studentvue.controllers;

import java.util.Arrays;
import java.util.List;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.studentvue.models.FamilyNameModel;
import com.service.studentvue.services.FamilyNameService;

@CrossOrigin(origins = "*") //@CrossOrigin annotation enables cross-origin resource sharing only for this specific method
@RestController //@RestController annotation in order to simplify the creation of RESTful web services. It's a convenient annotation that combines @Controller and @ResponseBody, which eliminates the need to annotate every request handling method of the controller class with the
@RequestMapping("/api") //RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
//controllers are like the traffic cops of our application. They handle the requests made from users
// interacting with the application's view and update model data accordingly
public class FamilyNameController {

    @Autowired
    private FamilyNameService _familyNameService;
    @RequestMapping(value="/allnames", method= RequestMethod.GET) //RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
    public List<FamilyNameModel> getAllFamilyNames() {
        return Arrays.asList(
                new FamilyNameModel("999e49c-cdc2-446c-8670-62ada2a67fbe", "Judy", "Johnson - Backend"),
                new FamilyNameModel("a56a8599-9945-4a98-bce0-b0f376f1bb7a", "Kenneth", "Smith - Backend"),
                new FamilyNameModel("dfc0ab4d-1026-4f0c-9185-bdc0ea283e2c", "Derrick", "Zantt - Backend"),
                new FamilyNameModel("3605834f-c70a-415d-a952-d01e4b219146", "Mohamed", "Kings - Backend"),
                new FamilyNameModel("07f11df2-4115-42a5-8c3d-44ba737370e9", "Kincade", "Burroughs - Backend"),
                new FamilyNameModel("4d859eeb-9a91-494a-819d-28c91f05211b", "Dan", "Daniels - Backend")
        );
    }
    
    @RequestMapping(value="/findallnames", method= RequestMethod.GET) //RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
    public List<FamilyNameModel> getFamilyNames() {
		return _familyNameService.findAll();
	
	}
	
    @RequestMapping(value = "/createfamilyname", method= RequestMethod.POST)
	public void createFamilyName(@RequestBody FamilyNameModel fname) {
    	_familyNameService.insertFamilyName(fname);
	
	}
    @RequestMapping(value = "/updatefamilyname", method= RequestMethod.PUT)
	public void updateFamilyName(@RequestBody FamilyNameModel fname) {
    	_familyNameService.updateFamilyName(fname);
	
	}
    //returns one object because it's only looking for the record who's Id is the parameter
    @RequestMapping(value="/findbyId/{id}", method= RequestMethod.GET) 
    public FamilyNameModel getFamilyNameById(@PathVariable("id") String id) {
		return _familyNameService.findById(id);
	
	}

}
