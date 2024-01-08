package com.service.studentvue.repositories;

import com.service.studentvue.db_model_mapper.GradeLevelRowMapper;
import com.service.studentvue.models.GradeLevelModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class GradeLevelRepository {
    private NamedParameterJdbcTemplate template;

    public GradeLevelRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<GradeLevelModel> findAll() {
        return template.query("SELECT * FROM gradelevels", new GradeLevelRowMapper());
    }

    public void insertGradeLevel(GradeLevelModel grade) {
        final String sql = """
                           INSERT INTO gradelevels(id, abreviation, name)
                           VALUES (:Id, :abreviation, :name)
                           """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(grade.getId()))
                .addValue("abreviation", grade.getAbreviation())
                .addValue("name", grade.getName());
        template.update(sql, param);
    }

    public void updateGradeLevel(GradeLevelModel grade) {
        final String sql = """
                           UPDATE gradelevels SET abreviation=:abreviation, name=:name
                           WHERE Id=:Id;
                           """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(grade.getId()))
                .addValue("abreviation", grade.getAbreviation())
                .addValue("name", grade.getName());

        template.update(sql, param);
    }

    public GradeLevelModel findById(String id) {
        final String sql = "SELECT * FROM gradelevels WHERE ID= :Id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        try {
            return template.queryForObject(sql, param, new GradeLevelRowMapper());
        } catch (EmptyResultDataAccessException e) {
            // Log the exception or handle it based on your application's needs
            // For example, you might want to return a default AgeModel or throw a custom exception
            e.printStackTrace(); // Log the exception
        } catch (Exception e) {
            // Log the exception or handle it based on your application's needs
            e.printStackTrace(); // Log the exception
        }

        return null;
    }
}
