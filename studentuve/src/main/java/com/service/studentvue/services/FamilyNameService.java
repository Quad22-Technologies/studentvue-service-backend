package com.service.studentvue.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.studentvue.dao.FamilyNameDao;
import com.service.studentvue.models.FamilyNameModel;

import jakarta.annotation.Resource;

@Service
public class FamilyNameService implements IFamilyNameService{

	@Resource 
	FamilyNameDao _familyNameDao;
		
	@Override
	public List<FamilyNameModel> findAll() {
		return _familyNameDao.findAll();
	}

	@Override
	public void insertFamilyName(FamilyNameModel fname) {
		// TODO Auto-generated method stub
		
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
