package com.service.studentvue.db_model_mapper;

import com.service.studentvue.models.StudentModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<StudentModel> {
    @Override
    public StudentModel mapRow(ResultSet rs, int rowNumber) throws SQLException {
        StudentModel student = new StudentModel();

        student.setId(rs.getObject("id", java.util.UUID.class).toString());
        student.setUserId(rs.getString("users_id"));
        student.setGradeLevelId(rs.getString("gradelevels_id"));
        student.setParentId(rs.getString("parent_id"));

        return student;
    }
}