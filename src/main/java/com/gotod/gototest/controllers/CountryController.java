package com.gotod.gototest.controllers;

import com.gotod.gototest.domain.Country;
import com.gotod.gototest.domain.Role;
import com.gotod.gototest.services.CountryService;
import com.gotod.gototest.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CountryController {

	@Autowired
		private CountryService countryService;

	@GetMapping("/country")
	public List<Country> getCountry() {

		return countryService.consultCountry();
	}


}