package com.service.studentvue.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.service.studentvue.models.AgeModel;
import com.service.studentvue.models.FamilyNameModel;
import com.service.studentvue.repositories.FamilyNameRepository;

import jakarta.annotation.Resource;

@Service
public class FamilyNameService {

	@Resource 
	FamilyNameRepository _familyNameRepository;
		
	public List<FamilyNameModel> findAll() {
		return _familyNameRepository.findAll();
	}

	public FamilyNameModel insertFamilyName(FamilyNameModel fname) {
		/*setting UUID for inserting a new record this is because we have changed 
		our database to use UUID's or GUID's instead of Auto incremented numbers for Primary Keys
		example: 018b2f19-e79e-7d6a-a56d-29feb6211b04  */
		UUID uuid = UUID.randomUUID();
		fname.setId(uuid.toString());
		return _familyNameRepository.insertFamilyName(fname);
		
	}

	public void updateFamilyName(FamilyNameModel fname) {
		_familyNameRepository.updateFamilyName(fname);
		
	}
	
	public FamilyNameModel findById(String id) {
		return _familyNameRepository.findById(id);
	}

	public FamilyNameModel findAgeById(String id) {
		FamilyNameModel fNameModel = _familyNameRepository.findById(id); //1. get the family name 1st

        if(fNameModel != null) //check to see if the object that's returned from the database is not null;
		{
           AgeModel ageM = _familyNameRepository.findAgeById(id); //2. get the age 2nd. query the db for family member age
		 
		   if(ageM != null)
		   {
			  fNameModel.setFamilyAgeModel(ageM);
		   }

		}


		return fNameModel;
	}

	//returns a list of amily names and their age
	public List<FamilyNameModel> findAllNamesAgeById() {
		
		List<FamilyNameModel> fNamelist= _familyNameRepository.findAll(); 

        if(fNamelist != null) //check to see if the object that's returned from the database is not null;
		{
			for(int i = 0; i < fNamelist.size(); i++) // iterate through the list and attached the age
			{
            
			AgeModel ageM = _familyNameRepository.findAgeById(fNamelist.get(i).getId()); //2. get the age 2nd. query the db for family member age
		 
		   if(ageM != null)
		   {
			  fNamelist.get(i).setFamilyAgeModel(ageM);
		   }
		  
		  }
      
		}

		return fNamelist;
	}
	

}
