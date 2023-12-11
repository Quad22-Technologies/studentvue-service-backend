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

	public FamilyNameModel findFamilyNameWithAgeById(String id) {
		FamilyNameModel fNameModel = _familyNameRepository.findById(id); //1. get the family name 1st

        if(fNameModel != null) //check to see if the object that's returned from the database is not null;
		{
           AgeModel ageM = _familyNameRepository.findFamilyNameWithAgeById(id); //2. get the age 2nd. query the db for family member age
		 
		   if(ageM != null)
		   {
			  fNameModel.setFamilyAgeModel(ageM);
		   }

		}


		return fNameModel;
	}
/*findAllNamesAge method retrieves a list of FamilyNameModel objects
 and then, for each family name, fetches the corresponding 
 AgeModel from the database and attaches it to the FamilyNameModel */
	public List<FamilyNameModel> findAllNamesWithAge() {
		List<FamilyNameModel> fNamelist = _familyNameRepository.findAll();
	
		if (fNamelist != null) {
			
			for (FamilyNameModel familyName : fNamelist) { 
			// Code to be executed for each FamilyNameModel in the list
			// familyName represents the current element in the iteration
			// You can access its properties and perform operations
			AgeModel ageM = _familyNameRepository.findFamilyNameWithAgeById(familyName.getId());

			if (ageM != null) {
				familyName.setFamilyAgeModel(ageM);
			}
		  }
				
		}
		return fNamelist;
	}

	public void deleteFamilyNameById(String id)
	{
		_familyNameRepository.deleteFamilyNameById(id);
	}
}
