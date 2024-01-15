package com.service.studentvue.repositories;

import com.service.studentvue.db_model_mapper.ClassGradeRowMapper;
import com.service.studentvue.models.ClassGradeModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ClassGradeRepository {
    NamedParameterJdbcTemplate template;

    public ClassGradeRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<ClassGradeModel> findAll() {
        return template.query("select * from classgrades", new ClassGradeRowMapper());
    }

    public ClassGradeModel insertClassGrade(ClassGradeModel grade) {
        final String sql = """
                INSERT INTO classgrades(id, student_id, teacher_id, classname_id, grade)
                VALUES (:Id, :student_id, :teacher_id, :classname_id, :grade)
                """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(grade.getId()))
                .addValue("student_id",
                        grade.getStudentId() != null ? UUID.fromString(grade.getStudentId()) : null)
                .addValue("teacher_id",
                        grade.getTeacherId() != null ? UUID.fromString(grade.getTeacherId()) : null)
                .addValue("classname_id",
                        grade.getClassNameId() != null ? UUID.fromString(grade.getClassNameId()) : null)
                .addValue("student_id", grade.getGrade());
        template.update(sql,param);

        param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(grade.getId()));

        final String selectSql = "SELECT * FROM classgrades WHERE id=:Id";

        try {
            return template.queryForObject(selectSql, param, new ClassGradeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no records are found
            return null; // Or throw an exception, log a message, etc.
        }
    }

    public void updateClassGrade(ClassGradeModel grade) {
        final String sql = """
                UPDATE classgrades SET student_id=:student_id, teacher_id=:teacher_id,
                                       classname_id=:classname_id, grade=:grade WHERE Id=:Id
                """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(grade.getId()))
                .addValue("student_id",
                        grade.getStudentId() != null ? UUID.fromString(grade.getStudentId()) : null)
                .addValue("teacher_id",
                        grade.getTeacherId() != null ? UUID.fromString(grade.getTeacherId()) : null)
                .addValue("classname_id",
                        grade.getClassNameId() != null ? UUID.fromString(grade.getClassNameId()) : null)
                .addValue("student_id", grade.getGrade());

        template.update(sql,param);
    }

    public ClassGradeModel findById(String id) {
        final String sql = "SELECT * FROM classgrades WHERE Id = :Id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        try {
            return template.queryForObject(sql, param, new ClassGradeRowMapper());

        } catch (EmptyResultDataAccessException e) {
            return null; // Or throw an exception, log a message, etc.
        }
    }

    public List<ClassGradeModel> findByUserId(String id) {
        final String sql = "SELECT * FROM classgrades WHERE student_id = :student_id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("student_id", UUID.fromString(id));

        try {
            return template.query(sql, param, new ClassGradeRowMapper());

        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no records are found
            return null; // Or throw an exception, log a message, etc.
        }
    }

    public void deleteClassGradeById(String id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        template.update("DELETE FROM classgrades WHERE Id = :Id", parameters);
    }
}
