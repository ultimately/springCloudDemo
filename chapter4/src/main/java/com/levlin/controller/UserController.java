package com.levlin.controller;

import com.levlin.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: levlin
 * @Date: 2018/8/21
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @Author: levlin
     * @Date: 13:21 2018/8/21
     * @param:
     * @Description: 查询所有用户
     */
    @GetMapping(value = "/queryUsers")
    public List<User> queryUsers() {
        // 查询所有用户
        String sql = "select * from sys_user";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(User.class));
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id) {
        // 根据主键ID查询
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @DeleteMapping(value = "/{id}")
    public int delUser(@PathVariable Long id) {
        // 根据主键ID删除用户信息
        String sql = "DELETE FROM t_user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @PostMapping(value = "/addUser")
    public int addUser(@RequestBody User user) {
        // 添加用户
        String sql = "insert into t_user(username, password) values(?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }


    @PutMapping(value = "/{id}")
    public int editUser(@PathVariable Long id, @RequestBody User user) {
        // 根据主键ID修改用户信息
        String sql = "UPDATE t_user SET username = ? ,password = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), id);
    }

}
