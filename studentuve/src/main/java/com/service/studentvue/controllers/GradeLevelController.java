package com.service.studentvue.controllers;

import com.service.studentvue.models.gradelistModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class GradeLevelController {
    @GetMapping(value = "/grades")
    public List<gradelistModel> getGradelist() {
        return Arrays.asList(
                new gradelistModel(0, "K", "Kindergarten"),
                new gradelistModel(1,"1","1st Grade"),
                new gradelistModel(2,"2","2nd Grade"),
                new gradelistModel(3,"3","3rd Grade"),
                new gradelistModel(4,"4","4th Grade"),
                new gradelistModel(5,"5","5th Grade"),
                new gradelistModel(6,"6","6th Grade"),
                new gradelistModel(7,"7","7th Grade"),
                new gradelistModel(8,"8","8th Grade"),
                new gradelistModel(9,"9","9th Grade"),
                new gradelistModel(10,"10","10th Grade"),
                new gradelistModel(11,"11","11th Grade"),
                new gradelistModel(12,"12","12th Grade")

        );
    }
}
