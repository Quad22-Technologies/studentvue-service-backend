package com.service.studentvue.controllers;

import com.service.studentvue.models.GradeLevelModel;
import com.service.studentvue.models.gradelistModel;
import com.service.studentvue.services.GradeLevelService;
import com.service.studentvue.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class GradeLevelController {
    @Autowired
    private GradeLevelService _gradeLevelService;

    // This is to maintain compatability with the old endpoint
    // so the front-end doesn't break.
    @Deprecated
    @GetMapping(value = "/grades")
    public List<GradeLevelModel> getGradeLevels_old() {
        return _gradeLevelService.findAll();
    }

    @GetMapping(value = "/gradelevels/all")
    public List<GradeLevelModel> getGradeLevels() {
        return _gradeLevelService.findAll();
    }

    @GetMapping(value = "/gradelevels/{id}")
    public GradeLevelModel getGradeLevels(@PathVariable("id") String id) {
        return _gradeLevelService.findById(id);
    }
}
