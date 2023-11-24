package com.service.studentvue.services;

import java.util.List;

import com.service.studentvue.models.FamilyNameModel;

public interface IFamilyNameService {
	
	List<FamilyNameModel> findAll();

	void insertFamilyName(FamilyNameModel fname);

	void updateFamilyName(FamilyNameModel fname);

	void executeUpdateFamilyName(FamilyNameModel fname);

	public void deleteFamilyName(FamilyNameModel fname);
}
