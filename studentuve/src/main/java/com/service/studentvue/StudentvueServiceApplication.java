package com.service.studentvue;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
