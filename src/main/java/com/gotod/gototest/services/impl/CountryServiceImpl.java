package com.gotod.gototest.services.impl;



import com.gotod.gototest.domain.Country;
import com.gotod.gototest.repositories.CountryRepository;
import com.gotod.gototest.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> consultCountry() {

        return countryRepository.consultCountry();
    }


}
