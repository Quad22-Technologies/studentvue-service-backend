package com.service.studentvue.services;

import java.util.List;

import com.service.studentvue.models.RegistrationModel;

public interface IRegistrationService {
	
	List<RegistrationModel> findAll();
	List<RegistrationModel> findKincade();
	RegistrationModel findKincadeById(String id);


    /* 
	void insertFamilyName(RegistrationModel fname);

	void updateFamilyName(RegistrationModel fname);

	RegistrationModel findById(String id);
	
	void executeUpdateRegistration(RegistrationModel fname);

	public void deleteFamilyName(RegistrationModel fname);
    */
}
