package com.gotod.gototest.repositories.impl;

import com.gotod.gototest.repositories.RoleRepository;
import com.gotod.gototest.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Role> consultRole() {
        String sql = "select * from covid19.role";
        List<Role> roles = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Role.class));
        return roles;
    }


}
