package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.CountryDao;
import com.cognizant.spring_learn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public Country addCountry(Country country) {
        return countryDao.addCountry(country);
    }
}