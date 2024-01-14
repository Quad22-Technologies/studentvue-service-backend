package com.service.studentvue.repositories;

import com.service.studentvue.db_model_mapper.UserRowMapper;
import com.service.studentvue.models.UserModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    NamedParameterJdbcTemplate template;

    public UserRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<UserModel> findAll() {
        return template.query("select * from Users", new UserRowMapper());
    }

    public UserModel insertUser(UserModel user) {
        final String sql = """
                INSERT INTO users(id, firstname, lastname, address, city, zipcode, state, gradelevels_id,
                                  parent_id, isteacher, isstudent, isparent, emailaddress, username, passwordhashed, salt)
                VALUES (:Id, :firstname, :lastname, :address, :city, :zipcode, :state, :gradelevels_id, :parent_id, :isteacher,
                        :isstudent, :isparent, :emailaddress, :username, :passwordhashed, :salt)
                """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(user.getId()))
                .addValue("firstname", user.getFirstName())
                .addValue("lastname", user.getLastName())
                .addValue("address", user.getAddress())
                .addValue("city", user.getCity())
                .addValue("zipcode", user.getZipCode())
                .addValue("state", user.getState())
                .addValue("gradelevels_id",
                        user.getGradeLevelId() != null ? UUID.fromString(user.getGradeLevelId()) : null)
                .addValue("parent_id",
                        user.getParentId() != null ? UUID.fromString(user.getParentId()) : null)
                .addValue("isteacher", user.isTeacher())
                .addValue("isstudent", user.isStudent())
                .addValue("isparent", user.isParent())
                .addValue("emailaddress", user.getEmail())
                .addValue("username", user.getUsername())
                .addValue("passwordhashed", user.getPassword())
                .addValue("salt", user.getSalt());

        template.update(sql,param);

        param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(user.getId()));

        final String selectSql = "SELECT * FROM users WHERE id=:Id";

        try {
            return template.queryForObject(selectSql, param, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no records are found
            return null; // Or throw an exception, log a message, etc.
        }
    }

    public void updateUser(UserModel user) {
        final String sql = """
                UPDATE users SET firstname=:firstname, lastname=:lastname, city=:city, zipcode=:zipcode, state=:state, gradelevels_id=:gradelevels_id,
                                 parent_id=:parent_id, isteacher=:isteacher, isstudent=:isstudent, isparent=:isparent, emailaddress=:emailaddress,
                                 passwordhashed=:passwordhashed, salt=:salt WHERE Id=:Id
                """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(user.getId()))
                .addValue("firstname", user.getFirstName())
                .addValue("lastname", user.getLastName())
                .addValue("address", user.getAddress())
                .addValue("city", user.getCity())
                .addValue("zipcode", user.getZipCode())
                .addValue("state", user.getState())
                .addValue("gradelevels_id", UUID.fromString(user.getGradeLevelId()))
                .addValue("parent_id", UUID.fromString(user.getParentId()))
                .addValue("isteacher", user.isTeacher())
                .addValue("isstudent", user.isStudent())
                .addValue("isparent", user.isParent())
                .addValue("emailaddress", user.getEmail())
                .addValue("username", user.getUsername())
                .addValue("passwordhashed", user.getPassword())
                .addValue("salt", user.getSalt());

        template.update(sql,param);

    }

    public UserModel findById(String id) {
        final String sql = "SELECT * FROM users WHERE Id = :Id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        try {
            return template.queryForObject(sql, param, new UserRowMapper());

        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no records are found
            return null; // Or throw an exception, log a message, etc.

        }
    }

    public void deleteUserById(String id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        template.update("DELETE FROM users WHERE Id = :Id", parameters);
    }
}
