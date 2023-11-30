package com.service.studentvue.repositories;

import java.util.List;
import java.util.UUID;

import com.service.studentvue.db_model_mapper.FamilyNameRowMapper;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.service.studentvue.models.RegistrationModel;

@Repository
public class RegistrationRepository implements IRegistrationRepository {
	
	public RegistrationRepository(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  //allows you to use names as paramater values to be inserted vs ? see :firstname,  :lastname these represents the param.

	@Override
	public List<RegistrationModel> findAll() {
		return template.query("select * from tb_reginfo", new RegistrationRowMapper());
	}

	@Override
	public void insertRegUser(RegistrationModel fname) {
		 final String sql = "insert into tb_reginfo(id, firstname, lastname) values(:Id, :firstname,:lastname)";
		      
	        		
	        SqlParameterSource param = new MapSqlParameterSource()
	        		.addValue("Id", UUID.fromString(fname.getId())) //UUID.fromString(fname.getId()); the fromstring converts the String ID to UUID type for the database
					.addValue("firstname", fname.getFirstname())
					.addValue("lastname", fname.getLastname());
	        template.update(sql,param);
	 
	}
	
	@Override
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
	
    /* 
	@Override
	public void deleteFirstName(RegistrationModel fname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeUpdateRegistration(RegistrationModel fname) {
		// TODO Auto-generated method stub
		
	}
    */

	

}