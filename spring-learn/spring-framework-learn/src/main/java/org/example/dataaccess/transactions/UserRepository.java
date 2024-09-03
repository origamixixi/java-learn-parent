package org.example.dataaccess.transactions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepository {

    public static final String CHEAT = "外挂角色";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void createRole(String roleName) {
        int id = getUserCount() + 1;
        jdbcTemplate.update("INSERT INTO user_role (id, role_name) VALUES (?, ?)", id, roleName);
        if (UserRepository.CHEAT.equals(roleName)) {
            throw new RuntimeException(String.format("[%s]不允许插入，回滚", roleName));
        }
    }

    public int getUserCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user_role", Integer.class);
    }

    public List<String> listAllRoleNames() {
        return jdbcTemplate.query("SELECT * FROM user_role", (rs, rowNum) -> rs.getString("role_name"));
    }
}