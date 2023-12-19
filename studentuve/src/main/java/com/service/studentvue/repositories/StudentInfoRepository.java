package com.service.studentvue.repositories;
import com.service.studentvue.db_model_mapper.StudentRowMapper;
import com.service.studentvue.models.StudentModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class StudentInfoRepository {
    private NamedParameterJdbcTemplate template;

    public StudentInfoRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<StudentModel> findAll() {
        return template.query("SELECT * FROM students", new StudentRowMapper());
    }

    public void insertStudent(StudentModel student) {
        final String sql = """
                           INSERT INTO students(id, users_id, parent_id, gradelevels_id)
                           VALUES (:Id, :users_id, :parent_id, :gradelevels_id)
                           """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(student.getId()))
                .addValue("users_id", UUID.fromString(student.getUserId()))
                .addValue("parent_id", UUID.fromString(student.getParentId()))
                .addValue("gradelevels_id", UUID.fromString(student.getGradeLevelId()));
        template.update(sql, param);

    }

    public void updateStudent(StudentModel student) {
        final String sql = """
                           UPDATE students SET users_id=:users_id, parent_id=:parent_id,
                                               gradelevels_id=:gradelevels_id
                           WHERE Id=:Id;
                           """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(student.getId()))
                .addValue("users_id", UUID.fromString(student.getUserId()))
                .addValue("parent_id", UUID.fromString(student.getParentId()))
                .addValue("gradelevels_id", UUID.fromString(student.getGradeLevelId()));

        template.update(sql, param);

    }

    public void deleteStudentById(String id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        template.update("DELETE FROM students WHERE Id = :Id", parameters);
    }

    public StudentModel findById(String id) {
        final String sql = "SELECT * FROM students WHERE ID= :Id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        try {
            return template.queryForObject(sql, param, new StudentRowMapper());
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

    public StudentModel findByUserId(String id) {
        final String sql = "SELECT * FROM students WHERE users_id= :Id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        try {
            return template.queryForObject(sql, param, new StudentRowMapper());
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
