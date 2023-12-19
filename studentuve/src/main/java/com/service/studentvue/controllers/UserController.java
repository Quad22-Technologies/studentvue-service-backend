package com.service.studentvue.controllers;

import com.service.studentvue.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.service.studentvue.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService _userService;

    @RequestMapping(value="/users/all", method=RequestMethod.GET)
    public List<UserModel> getAllUsers() {
        return _userService.findAll();
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.GET)
    public UserModel getUserByID(@PathVariable("id") String id) {
        return _userService.findById(id);
    }

    @RequestMapping(value="/users/create", method=RequestMethod.POST)
    public UserModel createUser(@RequestBody UserModel user) {
        _userService.insertUser(user);
        return user;
    }

    @RequestMapping(value="/users/update", method=RequestMethod.PUT)
    public UserModel updateUser(@RequestBody UserModel user) {
        _userService.updateUser(user);
        return user;
    }

    @RequestMapping(value="/users/delete/{id}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") String id) {
        _userService.deleteUserByID(id);
    }
}
