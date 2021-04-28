package com.gotod.gototest.repositories.impl;



import com.gotod.gototest.domain.Country;
import com.gotod.gototest.domain.User;
import com.gotod.gototest.repositories.UserRepository;
import com.gotod.gototest.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> consultUsers() {
        String sql = "SELECT u.*, r.name as roleName,c.name as nameCountry, c.id as idCountry\n" +
                "FROM goto.users as u \n" +
                "inner join goto.role as r on u.idRole = r.id \n" +
                "inner join goto.country as c on u.idCountry=c.id";
        List<User> users=new ArrayList<>();
        List<Map<String, Object>> rows= jdbcTemplate.queryForList(sql);
        for(Map row:rows){
            User newUser = new User();
            newUser.setDescription((String) row.get("description"));
            newUser.setId(((String.format(row.get("id").toString()))));
            newUser.setUserName((String) row.get("userName"));
            newUser.setPassWord((String) row.get("password"));
            Role role=new Role();
            role.setId((String.format(row.get("idRole").toString())));
            role.setName((String) row.get("roleName"));
            newUser.setRole(role);
            Country country =new Country();
            country.setId((int) row.get("idCountry"));
            country.setName((String) row.get("nameCountry"));
            newUser.setCountry(country);

            users.add(newUser);}
        return users;
    }
    @Override
    public User upDateDescription(User user) {
        jdbcTemplate.update(
                "UPDATE goto.users SET description = ? WHERE id = ?",
                user.getDescription(), user.getId());
        return user;
    }
    @Override
    public User consultUser(String userName, String password){
        String sql = "SELECT u.*, r.name as roleName,c.name as nameCountry, c.id as idCountry\n" +
                "FROM goto.users as u \n" +
                "inner join goto.role as r on u.idRole = r.id \n" +
                "inner join goto.country as c on u.idCountry=c.id\n" +
                "where u.userName=? and u.password =?;";
        List<User> users=new ArrayList<>();
        List<Map<String, Object>> rows= jdbcTemplate.queryForList(sql ,new Object[] { userName ,password});
        for(Map row:rows){
            User newUser = new User();
            newUser.setId(((String.format(row.get("id").toString()))));
            newUser.setUserName((String) row.get("userName"));
            newUser.setPassWord((String) row.get("password"));
            Role role=new Role();
            role.setId((String.format(row.get("idRole").toString())));
            role.setName((String) row.get("roleName"));
            newUser.setRole(role);
            Country country =new Country();
            country.setId((int) row.get("idCountry"));
            country.setName((String) row.get("nameCountry"));
            newUser.setCountry(country);
            newUser.setDescription((String) row.get("description"));
            users.add(newUser);
        }
         return users.size()>0 ? users.get(0):null;
    }
    public User createUser(User user) {
        KeyHolder holder = new GeneratedKeyHolder();
        String sql= "INSERT INTO goto.users (userName,passWord,idRole) values(?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassWord());
                ps.setInt(3, Integer.parseInt(user.getRole().getId()));
                return ps;
            }
        }, holder);

        Long key=holder.getKey().longValue();

        user.setId(key.toString());

        return user  ;
    }

}
