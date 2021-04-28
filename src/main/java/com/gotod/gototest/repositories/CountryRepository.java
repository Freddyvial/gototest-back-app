package com.gotod.gototest.repositories;

import com.gotod.gototest.domain.Country;
import com.gotod.gototest.domain.Role;

import java.util.List;

public interface CountryRepository {

    List<Country> consultCountry();

}
