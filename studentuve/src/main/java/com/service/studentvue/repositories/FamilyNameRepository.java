package com.service.studentvue.repositories;
import java.util.List;
import java.util.UUID;

import com.service.studentvue.db_model_mapper.AgeRowMapper;
import com.service.studentvue.db_model_mapper.FamilyNameRowMapper;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.service.studentvue.models.AgeModel;
import com.service.studentvue.models.FamilyNameModel;

@Repository
public class FamilyNameRepository {
	
	public FamilyNameRepository(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  //allows you to use names as paramater values to be inserted vs ? see :firstname,  :lastname these represents the param.

	public List<FamilyNameModel> findAll() {
		return template.query("select * from tb_familynames", new FamilyNameRowMapper());
	}

	public FamilyNameModel insertFamilyName(FamilyNameModel fname) {
		 final String sql = "insert into tb_familynames(id, firstname, lastname) values(:Id, :firstname,:lastname)";
		      
	        		
	        SqlParameterSource param = new MapSqlParameterSource()
	        	.addValue("Id", UUID.fromString(fname.getId())) //UUID.fromString(fname.getId()); the fromstring converts the String ID to UUID type for the database
					.addValue("firstname", fname.getFirstname())
					.addValue("lastname", fname.getLastname());
	        template.update(sql,param);
	        
			 final String selectSql = "SELECT * FROM tb_familynames ORDER BY created_at DESC LIMIT 1";

			try {
				SqlParameterSource newparam = new MapSqlParameterSource();
				return template.queryForObject(selectSql, newparam, new FamilyNameRowMapper());
			
			} catch (EmptyResultDataAccessException e) {
				// Handle the case where no records are found
				return null; // Or throw an exception, log a message, etc.
			
			}     
	 
	}
	
	public void updateFamilyName(FamilyNameModel fname) {
		 final String sql = "update tb_familynames set firstname=:firstname, lastname=:lastname where Id=:Id";
		 
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("Id", UUID.fromString(fname.getId()))
					.addValue("firstname", fname.getFirstname())
					.addValue("lastname", fname.getLastname());
					
	        template.update(sql,param);
	   
	}
	
	public FamilyNameModel findById(String id) {
		final String sql = "SELECT * FROM tb_familynames WHERE Id = :Id";
		
		SqlParameterSource param = new MapSqlParameterSource()
			.addValue("Id", UUID.fromString(id));
	
		// queryForObject returns one object, in this case, the family name object
		try {
			return template.queryForObject(sql, param, new FamilyNameRowMapper());
		
		} catch (EmptyResultDataAccessException e) {
			// Handle the case where no records are found
			return null; // Or throw an exception, log a message, etc.
		
		}
	}
	
	public AgeModel findFamilyNameWithAgeById(String id) {
		final String sql = "SELECT * FROM tb_age WHERE familyname_Id = :Id";
		
		SqlParameterSource param = new MapSqlParameterSource()
			.addValue("Id", UUID.fromString(id));
	
		try {
			return template.queryForObject(sql, param, new AgeRowMapper());
		} catch (EmptyResultDataAccessException e) {
			// Log the exception or handle it based on your application's needs
			// For example, you might want to return a default AgeModel or throw a custom exception
			e.printStackTrace(); // Log the exception
		} catch (Exception e) {
			// Log the exception or handle it based on your application's needs
			e.printStackTrace(); // Log the exception
		}
	
		return null;
	}
	
	public void deleteFamilyNameById(String id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource()
		.addValue("Id", UUID.fromString(id));

		template.update("DELETE FROM tb_familynames WHERE Id = :Id", parameters);
	}

}
