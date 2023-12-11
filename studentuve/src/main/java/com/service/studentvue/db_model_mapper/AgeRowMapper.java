package com.service.studentvue.db_model_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.service.studentvue.models.AgeModel;

public class AgeRowMapper implements RowMapper<AgeModel> {

	@Override
	public AgeModel mapRow(ResultSet rs, int arg1) throws SQLException {
		AgeModel age = new AgeModel();
		// Handling potential NULL values will be handeled at a later time
		age.setId(rs.getObject("id", java.util.UUID.class).toString()); 
		age.setAge(rs.getInt("age"));
		age.setFamilyname_Id(rs.getObject("familyname_Id", java.util.UUID.class).toString());
		 
		
		return age;
	}


}