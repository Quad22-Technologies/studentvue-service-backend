package com.service.studentvue.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.service.studentvue.models.RegistrationModel;
import com.service.studentvue.repositories.RegistrationRepository;

import jakarta.annotation.Resource;

@Service
public class RegistrationService implements IFamilyNameService{

	@Resource 
	RegistrationRepository _regDao;
		
	@Override
	public List<RegistrationModel> findAll() {
		return _regDao.findAll();
	}

	@Override
	public void insertFamilyName(FamilyNameModel fname) {
		/*setting UUID for inserting a new record this is because we have changed 
		our database to use UUID's or GUID's instead of Auto incremented numbers for Primary Keys
		example: 018b2f19-e79e-7d6a-a56d-29feb6211b04  */
		UUID uuid = UUID.randomUUID();
		fname.setId(uuid.toString());
		_familyNameDao.insertFamilyName(fname);
		
	}

	@Override
	public void updateFamilyName(FamilyNameModel fname) {
		_familyNameDao.updateFamilyName(fname);
		
	}
	
	@Override
	public FamilyNameModel findById(String id) {
		// TODO Auto-generated method stub
		return _familyNameDao.findById(id);
	}

	@Override
	public void executeUpdateFamilyName(FamilyNameModel fname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFamilyName(FamilyNameModel fname) {
		// TODO Auto-generated method stub
		
	}

	

}