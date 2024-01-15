package com.service.studentvue.controllers;


import com.service.studentvue.models.ClassGradeModel;
import com.service.studentvue.services.ClassGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClassGradeController {
    @Autowired
    private ClassGradeService _classGradeService;
    @RequestMapping(value="/grades/get/all", method= RequestMethod.GET)
    public List<ClassGradeModel> getAllClassGrade() {
        return _classGradeService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200") // Specify the allowed origin(s)
    @RequestMapping(value = "/grades/create", method= RequestMethod.POST)
    public ClassGradeModel createClassGrade(@RequestBody ClassGradeModel grade) {
        return _classGradeService.insertClassGrade(grade);
    }

    @CrossOrigin(origins = "http://localhost:4200") // Specify the allowed origin(s)
    @RequestMapping(value = "/grades/update", method= RequestMethod.PUT)
    public void updateClassGrade(@RequestBody ClassGradeModel grade) {
        _classGradeService.updateClassGrade(grade);
    }
    @RequestMapping(value="/grades/get/{id}", method= RequestMethod.GET)
    public ClassGradeModel getClassGradeById(@PathVariable("id") String id) {
        return _classGradeService.findById(id);
    }

    @RequestMapping(value="/grades/get/byUser/{id}", method= RequestMethod.GET)
    public List<ClassGradeModel> getClassGradeByUserId(@PathVariable("id") String id) {
        return _classGradeService.findByUserId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200") // Specify the allowed origin(s)
    @RequestMapping(value="/grades/delete/{id}", method= RequestMethod.DELETE)
    public void deleteClassGrade(@PathVariable("id") String id) {
        _classGradeService.deleteClassGradeById(id);
    }
}