package com.service.studentvue.controllers;

import com.service.studentvue.models.ClassNameModel;
import com.service.studentvue.services.ClassNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClassNamesController {
    @Autowired
    private ClassNameService _classNameService;
    @RequestMapping(value="/classes/get/all", method= RequestMethod.GET)
    public List<ClassNameModel> getAllClassNames() {
        return _classNameService.findAll();
    }

    /**Creates a completely new user, assuming unhashed info*/
    @CrossOrigin(origins = "http://localhost:4200") // Specify the allowed origin(s)
    @RequestMapping(value = "/classes/create", method= RequestMethod.POST)
    public ClassNameModel createClassName(@RequestBody ClassNameModel classname) {
        return _classNameService.insertClassName(classname);
    }

    @CrossOrigin(origins = "http://localhost:4200") // Specify the allowed origin(s)
    @RequestMapping(value = "/classes/update", method= RequestMethod.PUT)
    public void updateClassName(@RequestBody ClassNameModel classname) {
        _classNameService.updateClassName(classname);
    }

    //returns one object because it's only looking for the record who's Id is the parameter
    @RequestMapping(value="/classes/available/{uid}", method= RequestMethod.GET)
    public List<ClassNameModel> getAvailableClasses(@PathVariable("uid") String id) {
        return _classNameService.getAvailableClasses(id);
    }
    @RequestMapping(value="/classes/registered/{uid}", method= RequestMethod.GET)
    public List<ClassNameModel> getRegisteredClasses(@PathVariable("uid") String id) {
        return _classNameService.getRegisteredClasses(id);
    }

    //returns one object because it's only looking for the record who's Id is the parameter
    @CrossOrigin(origins = "http://localhost:4200") // Specify the allowed origin(s)
    @RequestMapping(value="/classes/delete/{id}", method= RequestMethod.DELETE)
    public void deleteClassName(@PathVariable("id") String id) {
        _classNameService.deleteClassNameById(id);
    }
}