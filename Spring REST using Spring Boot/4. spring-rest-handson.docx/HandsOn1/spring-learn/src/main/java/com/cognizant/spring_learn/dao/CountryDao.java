package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao {

    public Country addCountry(Country country) {
        return country;
    }
}