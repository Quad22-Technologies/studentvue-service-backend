package com.service.studentvue.db_model_mapper;

import com.service.studentvue.models.ClassGradeModel;
import com.service.studentvue.models.ClassNameModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassGradeRowMapper implements RowMapper<ClassGradeModel> {
    @Override
    public ClassGradeModel mapRow(ResultSet rs, int rowNumber) throws SQLException {
        ClassGradeModel grade = new ClassGradeModel();

        grade.setId(rs.getObject("id", java.util.UUID.class).toString());
        if (rs.getObject("student_id", java.util.UUID.class) != null)
            grade.setStudentId(rs.getObject("student_id", java.util.UUID.class).toString());
        if (rs.getObject("teacher_id", java.util.UUID.class) != null)
            grade.setTeacherId(rs.getObject("teacher_id", java.util.UUID.class).toString());
        if (rs.getObject("classname_id", java.util.UUID.class) != null)
            grade.setClassNameId(rs.getObject("classname_id", java.util.UUID.class).toString());
        grade.setGrade(rs.getFloat("grade"));

        return grade;
    }
}