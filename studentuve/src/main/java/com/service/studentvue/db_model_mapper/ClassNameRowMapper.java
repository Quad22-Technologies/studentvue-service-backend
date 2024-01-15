package com.service.studentvue.db_model_mapper;

import com.service.studentvue.models.ClassNameModel;
import com.service.studentvue.models.GradeLevelModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassNameRowMapper implements RowMapper<ClassNameModel> {
    @Override
    public ClassNameModel mapRow(ResultSet rs, int rowNumber) throws SQLException {
        ClassNameModel classname = new ClassNameModel();

        classname.setId(rs.getObject("id", java.util.UUID.class).toString());
        classname.setName(rs.getString("name"));
        classname.setRoomNumber(rs.getString("room_number"));

        if (rs.getObject("teacher_id", java.util.UUID.class) != null)
            classname.setTeacherId(rs.getObject("teacher_id", java.util.UUID.class).toString());

        return classname;
    }
}
