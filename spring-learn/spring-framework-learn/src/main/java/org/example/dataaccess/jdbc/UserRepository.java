package org.example.dataaccess.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> listAllRoleNames() {
        return jdbcTemplate.query("SELECT * FROM user_role", (rs, rowNum) -> rs.getString("role_name"));
    }
}