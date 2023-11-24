package com.service.studentvue.repositories;

import java.util.List;
import com.service.studentvue.db_model_mapper.FamilyNameRowMapper;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.service.studentvue.models.FamilyNameModel;

@Repository
public class FamilyNameDao implements IFamilyNameDao {
	
	public FamilyNameDao(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<FamilyNameModel> findAll() {
		return template.query("select * from tb_familynames", new FamilyNameRowMapper());
	}

	@Override
	public void insertFamilyName(FamilyNameModel fname) {
		 final String sql = "insert into tb_familynames(firstname, lastname) values(:firstname,:lastname)";
		 
	        GeneratedKeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
	        		.addValue("Id", fname.getId())
					.addValue("firstname", fname.getFirstname())
					.addValue("lastname", fname.getLastname());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateFamilyName(FamilyNameModel fname) {
		 final String sql = "update tb_familynames set firstname=:firstname, lastname=:lastname where Id=:Id";
		 
	        GeneratedKeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("Id", fname.getId())
					.addValue("firstname", fname.getFirstname())
					.addValue("lastname", fname.getLastname());
					
	        template.update(sql,param, holder);
	 
	}
	
	
	@Override
	public void deleteFamilyName(FamilyNameModel fname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeUpdateFamilyName(FamilyNameModel fname) {
		// TODO Auto-generated method stub
		
	}

}
