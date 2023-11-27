package com.service.studentvue.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.service.studentvue.models.FamilyNameModel;
import com.service.studentvue.repositories.FamilyNameRepository;

import jakarta.annotation.Resource;

@Service
public class FamilyNameService {

	@Resource 
	FamilyNameRepository _familyNameDao;
		
	public List<FamilyNameModel> findAll() {
		return _familyNameDao.findAll();
	}

	public void insertFamilyName(FamilyNameModel fname) {
		/*setting UUID for inserting a new record this is because we have changed 
		our database to use UUID's or GUID's instead of Auto incremented numbers for Primary Keys
		example: 018b2f19-e79e-7d6a-a56d-29feb6211b04  */
		UUID uuid = UUID.randomUUID();
		fname.setId(uuid.toString());
		_familyNameDao.insertFamilyName(fname);
		
	}

	public void updateFamilyName(FamilyNameModel fname) {
		_familyNameDao.updateFamilyName(fname);
		
	}
	
	public FamilyNameModel findById(String id) {
		// TODO Auto-generated method stub
		return _familyNameDao.findById(id);
	}

	public void executeUpdateFamilyName(FamilyNameModel fname) {
		// TODO Auto-generated method stub
		
	}


	public void deleteFamilyName(FamilyNameModel fname) {
		// TODO Auto-generated method stub
		
	}

	

}
