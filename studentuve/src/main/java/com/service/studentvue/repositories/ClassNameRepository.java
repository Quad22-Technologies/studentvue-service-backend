package com.service.studentvue.repositories;

import com.service.studentvue.db_model_mapper.ClassNameRowMapper;
import com.service.studentvue.db_model_mapper.GradeLevelRowMapper;
import com.service.studentvue.models.ClassNameModel;
import com.service.studentvue.models.GradeLevelModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ClassNameRepository {
    private NamedParameterJdbcTemplate template;

    public ClassNameRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<ClassNameModel> findAll() {
        return template.query("SELECT * FROM classnames", new ClassNameRowMapper());
    }

    public void insertClassName(ClassNameModel classname) {
        final String sql = """
                           INSERT INTO classnames(id, name, room_number, teacher_id)
                           VALUES (:Id, :name, :room_number, :teacher_id)
                           """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(classname.getId()))
                .addValue("name", classname.getName())
                .addValue("room_number", classname.getName())
                .addValue("teacher_id",
                        classname.getTeacherId() != null ? UUID.fromString(classname.getId()) : null);

        template.update(sql, param);
    }

    public void updateClassName(ClassNameModel classname) {
        final String sql = """
                           UPDATE classnames SET name=:name, room_number=:room_number,
                           teacher_id=:teacher_id
                           WHERE Id=:Id;
                           """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(classname.getId()))
                .addValue("name", classname.getName())
                .addValue("room_number", classname.getName())
                .addValue("teacher_id",
                        classname.getTeacherId() != null ? UUID.fromString(classname.getId()) : null);

        template.update(sql, param);
    }

    public ClassNameModel findById(String id) {
        final String sql = "SELECT * FROM classnames WHERE ID= :Id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        try {
            return template.queryForObject(sql, param, new ClassNameRowMapper());
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

    // get all classes a user has NOT registered for
    public List<ClassNameModel> getAvailableClasses(String id) {
        final String sql = "SELECT * FROM classnames WHERE id NOT IN (SELECT classname_id FROM classgrades WHERE student_id= :Id);";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        try {
            return template.query(sql, param, new ClassNameRowMapper());
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

    public List<ClassNameModel> getRegisteredClasses(String id) {
        final String sql = "SELECT * FROM classnames WHERE id IN (SELECT classname_id FROM classgrades WHERE student_id= :Id);";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        try {
            return template.query(sql, param, new ClassNameRowMapper());
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

    public void deleteClassNameById(String id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        template.update("DELETE FROM classnames WHERE Id = :Id", parameters);
    }
}
