package com.wilbursandwilma.footlocker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilbursandwilma.footlocker.model.Admin;

@Repository
public class LoginService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Admin validate(String username, String password) {
        try {
            Admin admin = jdbcTemplate.queryForObject("SELECT type FROM Admin WHERE username = ? AND password = ?",
                    BeanPropertyRowMapper.newInstance(Admin.class), username, password);

            return admin;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }




}




