package com.scnetcracker.dao;

import com.scnetcracker.entity.User;
import com.scnetcracker.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {


    public JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<User> findall() {
        String sql = "SELECT * FROM `user`";
        return jdbcTemplate.query(sql,new UserMapper());
    }
}
