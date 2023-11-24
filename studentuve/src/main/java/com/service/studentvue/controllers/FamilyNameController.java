package com.service.studentvue.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
                new FamilyNameModel(1, "Judy", "Johnson - Backend"),
                new FamilyNameModel(2, "Kenneth", "Smith - Backend"),
                new FamilyNameModel(3, "Derrick", "Zantt - Backend"),
                new FamilyNameModel(4, "Mohamed", "Kings - Backend"),
                new FamilyNameModel(5, "Kincade", "Burroughs - Backend"),
                new FamilyNameModel(6, "Dan", "Daniels - Backend")
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
    

}
