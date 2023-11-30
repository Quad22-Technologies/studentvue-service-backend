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
                new RegistrationModel(1, "Kincade", "Burroughs", "123 API St.", "Hughesville", "Maryland", "123455", "burgerking0o0", "burgerqueen101", "burgerqueen101", 12 ),
                new RegistrationModel(2, "Derrick", "Zantt", "456 Java ln.", "Waldorf", "Maryland", "123878", "jackoutthebox55", "cartirulez1", "cartirulez1", 12 ),
                new RegistrationModel(3, "Mohamed", "Keita", "3453 Python Ct.", "Waldorf", "Maryland", "125427", "Mo", "4theResume!", "4theResume!", 12 )
        );
    }

        @RequestMapping(value="/findallnames", method= RequestMethod.GET) //RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
    public List<RegistrationModel> getFamilyNames() {
		return _regService.findAll();
	
	}
	
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

}
