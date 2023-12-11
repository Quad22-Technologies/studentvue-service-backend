package com.service.studentvue.controllers;

import java.util.Arrays;
import java.util.List;

/* 
import javax.swing.Spring;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.service.studentvue.models.RegistrationModel;
import com.service.studentvue.services.RegistrationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private RegistrationService _regService;
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public List<RegistrationModel> getUserRegData() {
        return Arrays.asList(
                new RegistrationModel("190e2612-5366-401f-87ca-a0e4cdc466b1", "Kincade", "Burroughs", "123 API St.", "Hughesville", "Maryland", "123455", "burgerking0o0", "burgerqueen101", "burgerqueen101", 12 ),
                new RegistrationModel("e7fdd588-bd40-48fd-b36c-f81b9bc41a59", "Derrick", "Zantt", "456 Java ln.", "Waldorf", "Maryland", "123878", "jackoutthebox55", "cartirulez1", "cartirulez1", 12 ),
                new RegistrationModel("c57359b8-635c-4ae3-a261-8bd7179cda5b", "Mohamed", "Keita", "3453 Python Ct.", "Waldorf", "Maryland", "125427", "Mo", "4theResume!", "4theResume!", 12 )
        );
    }

        @RequestMapping(value="/findreginfo", method= RequestMethod.GET) //RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
    public List<RegistrationModel> getRegInfo() {
		return _regService.findAll();
	
	}

    @RequestMapping(value="/findkincade/{id}", method= RequestMethod.GET) //RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
    public List<RegistrationModel> getKincadeInfo(@PathVariable String id) {
        return _regService.findKincade();
    }

    @RequestMapping(value="/findkincadebyid/{id}", method= RequestMethod.GET) //RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
    public RegistrationModel getKincadeInfoById(@PathVariable("id") String id) {
        return _regService.findKincadeById(id);
    }

	/* 
    @RequestMapping(value = "/createfamilyname", method= RequestMethod.POST)
	public void createFamilyName(@RequestBody RegistrationModel fname) {
    	_regService.insertFamilyName(fname);
	
	}
    @RequestMapping(value = "/updatefamilyname", method= RequestMethod.PUT)
	public void updateFamilyName(@RequestBody RegistrationModel fname) {
    	_regService.updateFamilyName(fname);
	
	}
    //returns one object because it's only looking for the record who's Id is the parameter
    @RequestMapping(value="/findbyId/{id}", method= RequestMethod.GET) 
    public RegistrationModel getFamilyNameById(@PathVariable("id") String id) {
		return _regService.findById(id);
	
	}
    */

}
