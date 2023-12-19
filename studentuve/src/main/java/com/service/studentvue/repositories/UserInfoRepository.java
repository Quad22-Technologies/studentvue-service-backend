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
public class UserInfoRepository {
    private NamedParameterJdbcTemplate template;

    public UserInfoRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<UserModel> findAll() {
        return template.query("SELECT * FROM users", new UserRowMapper());
    }

    public void insertUser(UserModel user) {
        final String sql = """
                           INSERT INTO users(id, firstname, lastname, address,
                                             city, state, zipcode, isTeacher,
                                             isParent, isStudent)
                           VALUES (:Id, :firstname, :lastname, :address,
                                  :city, :state, :zipcode, :isTeacher,
                                  :isParent, :isStudent)
                           """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(user.getId()))
                .addValue("firstname", user.getFirstname())
                .addValue("lastname", user.getLastname())
                .addValue("address", user.getAddress())
                .addValue("city", user.getCity())
                .addValue("state", user.getState())
                .addValue("zipcode", user.getZipcode())
                .addValue("isTeacher", user.isTeacher())
                .addValue("isParent", user.isParent())
                .addValue("isStudent", user.isStudent());
        template.update(sql, param);
    }

    public void deleteUsersById(String id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        template.update("DELETE FROM users WHERE Id = :Id", parameters);
    }

    public void updateUser(UserModel user) {
        final String sql = """
                           UPDATE users SET firstname=:firstname, lastname=:lastname, address=:address,
                                            city=:city, state=:state, zipcode=:zipcode, isparent=:isparent,
                                            isstudent=:isstudent, isteacher=:isteacher
                           WHERE Id=:Id;
                           """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(user.getId()))
                .addValue("firstname", user.getFirstname())
                .addValue("lastname", user.getLastname())
                .addValue("address", user.getAddress())
                .addValue("city", user.getCity())
                .addValue("state", user.getState())
                .addValue("zipcode", user.getZipcode())
                .addValue("isTeacher", user.isTeacher())
                .addValue("isParent", user.isParent())
                .addValue("isStudent", user.isStudent());

        template.update(sql, param);
    }

    public UserModel findById(String id) {
        final String sql = "SELECT * FROM users WHERE ID= :Id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("Id", UUID.fromString(id));

        try {
            return template.queryForObject(sql, param, new UserRowMapper());
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
