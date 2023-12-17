package com.service.studentvue.services;

import java.util.List;
import java.util.UUID;
//import java.util.UUID;

import org.springframework.stereotype.Service;

import com.service.studentvue.models.RegistrationModel;
import com.service.studentvue.repositories.RegistrationRepository;

import jakarta.annotation.Resource;

@Service
public class RegistrationService{

	@Resource 
	RegistrationRepository _regDao;

	public List<RegistrationModel> findAll() {
		return _regDao.findAll();
	}

	public List<RegistrationModel> findKincade() {
		return _regDao.findKincade();
	}

	public RegistrationModel findKincadeById(String id) {
		return _regDao.findKincadeById(id);
	}

	public void insertRegData(RegistrationModel regdata) {
		UUID uuid = UUID.randomUUID();
		regdata.setId(uuid.toString());
		_regDao.insertRegData(regdata);
		
	}
	/*
	public void updateFamilyName(RegistrationModel fname) {
		_regDao.updateFamilyName(fname);
		
	}
	
	@Override
	public RegistrationModel findById(String id) {
		// TODO Auto-generated method stub
		return _regDao.findById(id);
	}

	@Override
	public void executeUpdateFamilyName(RegistrationModel fname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFamilyName(RegistrationModel fname) {
		// TODO Auto-generated method stub
		
	}
	*/
}