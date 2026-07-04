package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.CountryDao;
import com.cognizant.spring_learn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    public Country addCountry(Country country) {
        return countryDao.addCountry(country);
    }
}