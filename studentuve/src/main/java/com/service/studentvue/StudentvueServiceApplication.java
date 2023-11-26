package com.service.studentvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.service.studentvue.controllers.FamilyNameController;
import com.service.studentvue.controllers.GradeLevelController;
import com.service.studentvue.controllers.RegistrationController;
import com.service.studentvue.repositories.FamilyNameRepository;
import com.service.studentvue.services.FamilyNameService;

@SpringBootApplication
@ComponentScan(basePackageClasses={FamilyNameController.class, FamilyNameRepository.class, FamilyNameService.class, GradeLevelController.class, RegistrationController.class })
public class StudentvueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentvueServiceApplication.class, args);

	}
}
