package com.service.studentvue.repositories;
import java.util.List;
import java.util.UUID;
import com.service.studentvue.db_model_mapper.FamilyNameRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

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
	        
			//get the newly inserted record
			String insertedsql = "SELECT * FROM tb_familynames ORDER BY created_at DESC LIMIT 1";

			 var foundrecord  = template.query(insertedsql, new FamilyNameRowMapper()); 
	    return (FamilyNameModel)foundrecord.get(0); 
	     
	 
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
	    final String sql = "select * from tb_familynames where Id=:Id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("Id", UUID.fromString(id));

		//queryForObject returns one object in this case the family name object
	    var foundrecord  = template.queryForObject(sql, 
													param,
													new FamilyNameRowMapper()); 
	    return (FamilyNameModel)foundrecord; 
	}
	
	public FamilyNameModel findAgeById(String id) {
	    final String sql = "Select fn.Id, fn.firstname, fn.lastname, age.Id As AgeId, age.age As Age, age.familyname_Id " +
		                   "from tb_familynames fn, tb_age age Where fn.Id = age.familyname_Id AND  fn.Id=:Id";
		
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("Id", UUID.fromString(id));

		//queryForObject returns one object in this case the family name object
	    var foundrecord  = template.queryForObject(sql, 
													param,
													new FamilyNameRowMapper()); 
	    return (FamilyNameModel)foundrecord; 
	}	

	public List<FamilyNameModel> findAllNameAge() {
		return template.query("select fn.*,  age.Id As AgeId, age.age As Age, age.familyname_Id  " +
		                      "from tb_familynames fn, tb_age age Where fn.Id = age.familyname_Id", new FamilyNameRowMapper());
	}
}
