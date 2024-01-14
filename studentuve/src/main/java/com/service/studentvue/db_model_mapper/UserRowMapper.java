package com.service.studentvue.db_model_mapper;

import com.service.studentvue.models.GradeLevelModel;
import com.service.studentvue.models.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper<UserModel>{
    @Override
    public UserModel mapRow(ResultSet rs, int rowNumber) throws SQLException {
        UserModel user = new UserModel();

        user.setId(rs.getObject("id", java.util.UUID.class).toString());
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setAddress(rs.getString("address"));
        user.setCity(rs.getString("city"));
        user.setZipCode(rs.getString("zipCode"));
        user.setState(rs.getString("state"));

        if (rs.getObject("gradelevels_id") != null)
            user.setGradeLevelId(rs.getObject("gradelevels_id", java.util.UUID.class).toString());
        if (rs.getObject("parent_id") != null)
            user.setGradeLevelId(rs.getObject("parent_id", java.util.UUID.class).toString());

        user.setTeacher(rs.getBoolean("isteacher"));
        user.setStudent(rs.getBoolean("isstudent"));
        user.setParent(rs.getBoolean("isparent"));

        user.setEmail(rs.getString("emailAddress"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("passwordHashed"));
        user.setSalt(rs.getInt("salt"));

        return user;
    }
}
