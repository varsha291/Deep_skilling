package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Country;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryDao {

    private static List<Country> countryList = new ArrayList<>();

    static {
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("US", "United States"));
        countryList.add(new Country("UK", "United Kingdom"));
    }

    public List<Country> getAllCountries() {
        return countryList;
    }

    public Country addCountry(Country country) {
        countryList.add(country);
        return country;
    }
}