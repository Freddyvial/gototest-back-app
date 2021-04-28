package com.gotod.gototest.repositories.impl;

import com.gotod.gototest.domain.Country;
import com.gotod.gototest.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Country> consultCountry() {
        String sql = "select * from goto.country";
        List<Country> countries = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Country.class));
        return countries;
    }


}
