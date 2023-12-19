package com.service.studentvue.controllers;

import com.service.studentvue.models.StudentModel;
import com.service.studentvue.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService _studentService;

    @RequestMapping(value="/students/all", method= RequestMethod.GET)
    public List<StudentModel> getAllStudents() {
        return _studentService.findAll();
    }

    @RequestMapping(value="/students/byUserID/{id}", method=RequestMethod.GET)
    public StudentModel getStudentByID(@PathVariable("id") String id) {
        return _studentService.findByUserId(id);
    }

    @RequestMapping(value="/students/create", method=RequestMethod.POST)
    public StudentModel createStudent(@RequestBody StudentModel student) {
        _studentService.insertStudent(student);
        return student;
    }

    @RequestMapping(value="/students/update", method=RequestMethod.PUT)
    public StudentModel updateStudent(@RequestBody StudentModel student) {
        _studentService.updateStudent(student);
        return student;
    }

    @RequestMapping(value="/students/delete/{id}", method=RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") String id) {
        _studentService.deleteStudentByID(id);
    }

    @RequestMapping(value="/students/{id}", method=RequestMethod.GET)
    public StudentModel getStudentByUserID(@PathVariable("id") String id) {
        return _studentService.findById(id);
    }

}
