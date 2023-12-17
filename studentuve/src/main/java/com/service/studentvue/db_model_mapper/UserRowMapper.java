package com.service.studentvue.db_model_mapper;

import com.service.studentvue.models.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs, int rowNumber) throws SQLException {
        UserModel user = new UserModel();

        user.setId(rs.getObject("id", java.util.UUID.class).toString());
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setAddress(rs.getString("address"));
        user.setCity(rs.getString("city"));
        user.setState(rs.getString("state"));
        user.setZipcode(rs.getString("zipcode"));
        user.setStudent(rs.getBoolean("isStudent"));
        user.setTeacher(rs.getBoolean("isTeacher"));
        user.setParent(rs.getBoolean("isParent"));

        return user;
    }
}
