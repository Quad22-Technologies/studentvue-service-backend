package com.service.studentvue.db_model_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.service.studentvue.models.FamilyNameModel;

public class FamilyNameRowMapper implements RowMapper<FamilyNameModel> {

	@Override
	public FamilyNameModel mapRow(ResultSet rs, int arg1) throws SQLException {
		FamilyNameModel fm = new FamilyNameModel();
		fm.setId(rs.getObject("id", java.util.UUID.class).toString()); 
		fm.setFirstname(rs.getString("firstname"));
		fm.setLastname(rs.getString("lastname"));
	
		return fm;
	}


}