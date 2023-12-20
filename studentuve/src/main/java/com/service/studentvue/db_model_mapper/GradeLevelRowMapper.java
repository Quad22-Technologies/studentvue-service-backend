package com.service.studentvue.db_model_mapper;

import com.service.studentvue.models.GradeLevelModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeLevelRowMapper implements RowMapper<GradeLevelModel> {
    @Override
    public GradeLevelModel mapRow(ResultSet rs, int rowNumber) throws SQLException {
        GradeLevelModel grade = new GradeLevelModel();

        grade.setId(rs.getObject("id", java.util.UUID.class).toString());
        grade.setAbreviation(rs.getString("abreviation"));
        grade.setName(rs.getString("name"));

        return grade;
    }
}