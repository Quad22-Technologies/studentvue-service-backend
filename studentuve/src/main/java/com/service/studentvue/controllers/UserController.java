package com.service.studentvue.controllers;

import com.service.studentvue.models.RegistrationModel;
import com.service.studentvue.models.RegistrationResponseModel;
import com.service.studentvue.models.UserModel;
import com.service.studentvue.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService _userService;
    @RequestMapping(value="/users/get/all", method=RequestMethod.GET)
    public List<UserModel> getAllUsers() {
        return _userService.findAll();
    }


    // Register users in the typical way (via the website)
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/users/register", method=RequestMethod.POST)
    public RegistrationResponseModel registerUser(@RequestBody RegistrationModel regData) {
        return _userService.registerUser(regData);
    }

    /**Creates a completely new user, assuming unhashed info*/
    @CrossOrigin(origins = "http://localhost:4200") // Specify the allowed origin(s)
    @RequestMapping(value = "/users/create", method=RequestMethod.POST)
    public UserModel createUser(@RequestBody UserModel user) {
        return _userService.insertUnhashedUser(user);
    }

    /**Creates a new user, assuming hashed info*/
    @CrossOrigin(origins = "http://localhost:4200") // Specify the allowed origin(s)
    @RequestMapping(value = "/users/create_hashed", method=RequestMethod.POST)
    public UserModel createUserHashed(@RequestBody UserModel user) {
        return _userService.insertHashedUser(user);
    }

    @CrossOrigin(origins = "http://localhost:4200") // Specify the allowed origin(s)
    @RequestMapping(value = "/users/update", method=RequestMethod.PUT)
    public void updateUser(@RequestBody UserModel user) {
        _userService.updateUser(user);

    }
    //returns one object because it's only looking for the record who's Id is the parameter
    @RequestMapping(value="/users/get/{id}", method=RequestMethod.GET)
    public UserModel getUserById(@PathVariable("id") String id) {
        return _userService.findById(id);

    }

    //returns one object because it's only looking for the record who's Id is the parameter
    @CrossOrigin(origins = "http://localhost:4200") // Specify the allowed origin(s)
    @RequestMapping(value="/users/delete/{id}", method= RequestMethod.DELETE)
    public void deleteUsers(@PathVariable("id") String id) {
        _userService.deleteUserById(id);
    }
}
