package com.service.studentvue;

import java.util.Arrays;

import com.service.studentvue.controllers.*;
import com.service.studentvue.repositories.*;
import com.service.studentvue.services.ClassGradeService;
import com.service.studentvue.services.ClassNameService;
import com.service.studentvue.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.service.studentvue.services.FamilyNameService;

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
@ComponentScan(basePackageClasses={FamilyNameController.class, FamilyNameRepository.class, FamilyNameService.class,
								   GradeLevelController.class, RegistrationController.class,  UserService.class,
								   UserRepository.class, UserController.class, ClassNamesController.class,
								   ClassNameRepository.class, ClassNameService.class, ClassGradeRepository.class,
								   ClassGradeService.class, ClassGradeController.class})
public class StudentvueServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentvueServiceApplication.class, args);

	}
	
	@Bean
	public UrlBasedCorsConfigurationSource corsFilter() {
	
	    CorsConfiguration corsConfiguration = new CorsConfiguration();
	    corsConfiguration.setAllowCredentials(true);
	    corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
	    corsConfiguration.setAllowedMethods(Arrays.asList("*"));
	    corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", corsConfiguration);
	    return source;
	}

	
}
