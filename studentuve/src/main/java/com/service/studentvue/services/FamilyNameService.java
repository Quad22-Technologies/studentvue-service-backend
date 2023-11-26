package com.service.studentvue.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.service.studentvue.models.FamilyNameModel;
import com.service.studentvue.repositories.FamilyNameRepository;

import jakarta.annotation.Resource;

@Service
public class FamilyNameService implements IFamilyNameService{

	@Resource 
	FamilyNameRepository _familyNameDao;
		
	@Override
	public List<FamilyNameModel> findAll() {
		return _familyNameDao.findAll();
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
		// TODO Auto-generated method stub
		
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
