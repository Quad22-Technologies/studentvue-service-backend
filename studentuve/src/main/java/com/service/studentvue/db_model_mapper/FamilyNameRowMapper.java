package com.service.studentvue.db_model_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.service.studentvue.models.AgeModel;
import com.service.studentvue.models.FamilyNameModel;

public class FamilyNameRowMapper implements RowMapper<FamilyNameModel> {

	@Override
	public FamilyNameModel mapRow(ResultSet rs, int arg1) throws SQLException {
		FamilyNameModel fm = new FamilyNameModel();
		fm.setId(rs.getObject("id", java.util.UUID.class).toString()); 
		fm.setFirstname(rs.getString("firstname"));
		fm.setLastname(rs.getString("lastname"));
		 
		//setting the values for Age Model
		AgeModel am = new AgeModel();
		am.setId(rs.getObject("ageId", java.util.UUID.class).toString());
        am.setAge(rs.getInt("age"));
		am.setFamilyname_Id(rs.getObject("familyname_Id", java.util.UUID.class).toString());

		//here is where we are adding the new Age Model to the Family Name Model
		fm.setFamilyAgeModel(am);
        
		//
		return fm;
	}


}