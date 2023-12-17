package com.service.studentvue.repositories;

import java.util.List;
import java.util.UUID;


import com.service.studentvue.db_model_mapper.RegistrationRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/* 
import java.util.UUID;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
*/

import com.service.studentvue.models.RegistrationModel;

@Repository
public class RegistrationRepository {
	
	public RegistrationRepository(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  //allows you to use names as paramater values to be inserted vs ? see :firstname,  :lastname these represents the param.


	public List<RegistrationModel> findAll() {
		return template.query("select * from tb_reginfo", new RegistrationRowMapper());
	}


	public List<RegistrationModel> findKincade() {
		return template.query("select * from tb_reginfo where firstname = 'Kincade'", new RegistrationRowMapper());
	}


	public RegistrationModel findKincadeById(String id) {
		List<RegistrationModel> results = template.query("select * from tb_reginfo where id = '3d29dbf2-3ddb-4de9-a293-a63ab9c64771'", new RegistrationRowMapper());
		return (RegistrationModel) results.get(0);
	}



	public void insertRegData(RegistrationModel regdata) {
		 final String sql = "insert into tb_reginfo(id, firstname, lastname, address, city, states, zipcode, username, userpass, userpass2, usergrade) " +
				 							"values(:id, :firstname, :lastname, :address, :city, :states, :zipcode, :username, :userpass, :userpass2, :usergrade)";


		SqlParameterSource param = new MapSqlParameterSource()
	        		.addValue("id", UUID.fromString(regdata.getId())) //UUID.fromString(fname.getId()); the fromstring converts the String ID to UUID type for the database
					.addValue("firstname", regdata.getFirstName())
					.addValue("lastname", regdata.getLastName())
					.addValue("address", regdata.getAddress())
					.addValue("city", regdata.getCity())
					.addValue("states", regdata.getState())
					.addValue("zipcode", regdata.getZipCode())
					.addValue("username", regdata.getUsername())
					.addValue("userpass", regdata.getPassword())
					.addValue("userpass2", regdata.getPassword2())
					.addValue("usergrade", regdata.getGradelist());
	        template.update(sql,param);
	 
	}
	
	/*
	public void updateFirstName(RegistrationModel fname) {
		 final String sql = "update tb_familynames set firstname=:firstname, lastname=:lastname where Id=:Id";
		 
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("Id", UUID.fromString(fname.getId()))
					.addValue("firstname", fname.getFirstname())
					.addValue("lastname", fname.getLastname());
					
	        template.update(sql,param);
	 
	}
	
	public RegistrationModel findById(String id) {
	    final String sql = "select * from tb_familynames where Id = '" + id + "'";
	    var foundrecord  = template.query(sql, new RegistrationRowMapper()); //(FamilyNameModel) is a cast to turn the data coming from the database to match the FamilyNameModel
	    return (RegistrationModel)foundrecord.get(0); 
	}
	


	public void deleteFirstName(RegistrationModel fname) {
		// TODO Auto-generated method stub
		
	}


	public void executeUpdateRegistration(RegistrationModel fname) {
		// TODO Auto-generated method stub
		
	}
    
*/
	

}