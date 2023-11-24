package com.service.studentvue.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import com.service.studentvue.models.RegistrationModel;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RegistrationController {
    @GetMapping(value="/registration")
    public List<RegistrationModel> getUserRegData() {
        return Arrays.asList(
                new RegistrationModel(1, "Kincade", "Burroughs", "123 API St.", "Hughesville", "Maryland", "123455", "burgerking0o0", "burgerqueen101", "burgerqueen101", 12 ),
                new RegistrationModel(2, "Derrick", "Zantt", "456 Java ln.", "Waldorf", "Maryland", "123878", "jackoutthebox55", "cartirulez1", "cartirulez1", 12 ),
                new RegistrationModel(3, "Mohamed", "Keita", "3453 Python Ct.", "Waldorf", "Maryland", "125427", "Mo", "4theResume!", "4theResume!", 12 )
        );
    }
}
