package com.service.studentvue.repositories;

import java.util.List;

import com.service.studentvue.models.RegistrationModel;

public interface IRegistrationRepository {

	List<RegistrationModel> findAll();
	List<RegistrationModel> findKincade();
	RegistrationModel findKincadeById(String id);

	/* 
	void insertFamilyName(RegistrationModel fname);

	void updateFamilyName(RegistrationModel fname);
	
	RegistrationModel findById(String id);

	void executeUpdateFamilyName(RegistrationModel fname);

	public void deleteFamilyName(RegistrationModel fname);
	*/
}