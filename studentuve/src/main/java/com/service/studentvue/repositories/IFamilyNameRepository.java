package com.service.studentvue.repositories;

import java.util.List;

import com.service.studentvue.models.FamilyNameModel;

public interface IFamilyNameRepository {

	List<FamilyNameModel> findAll();

	void insertFamilyName(FamilyNameModel fname);

	void updateFamilyName(FamilyNameModel fname);

	void executeUpdateFamilyName(FamilyNameModel fname);

	public void deleteFamilyName(FamilyNameModel fname);
}