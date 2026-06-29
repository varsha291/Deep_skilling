package com.library.ormlearn.service;

import com.library.ormlearn.model.Country;
import com.library.ormlearn.repository.CountryRepository;
import com.library.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Hands-on 6
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found");
        }

        return result.get();
    }

    // Hands-on 7
    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    // Hands-on 8
    @Transactional
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    // Hands-on 9
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // Search Country
    public List<Country> searchCountry(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }

    // Get All Countries
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}