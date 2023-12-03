package com.service.studentvue.db_model_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.service.studentvue.models.RegistrationModel;

public class RegistrationRowMapper implements RowMapper<RegistrationModel> {

	@Override
	public RegistrationModel mapRow(ResultSet rs, int arg1) throws SQLException {
		RegistrationModel rm = new RegistrationModel();
		rm.setId(rs.getObject("id", java.util.UUID.class).toString()); 
		rm.setFirstName(rs.getString("firstname"));
		rm.setLastName(rs.getString("lastname"));
		rm.setAddress(rs.getString("address"));
		rm.setCity(rs.getString("city"));
		rm.setState(rs.getString("states"));
		rm.setZipCode(rs.getString("zipcode"));
		rm.setUsername(rs.getString("username"));
		rm.setPassword(rs.getString("userpass"));
		rm.setPassword2(rs.getString("userpass2"));
		rm.setGradelist(rs.getInt("usergrade"));

		 
        return rm;
	}


}