package com.library.ormlearn.service;

import com.library.ormlearn.model.Country;
import com.library.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Add Country
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    // Get Country by Code
    public Country getCountry(String code) {
        return countryRepository.findByCode(code);
    }

    // Update Country
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    // Delete Country
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // Search Country by Name
    public List<Country> searchCountry(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }

    // Get All Countries
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}