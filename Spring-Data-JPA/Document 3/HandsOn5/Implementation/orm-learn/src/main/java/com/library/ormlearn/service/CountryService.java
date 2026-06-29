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

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found");
        }

        return result.get();
    }

    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    public List<Country> searchCountry(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional
    public List<Country> searchCountrySorted(String name) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(name);
    }

    @Transactional
    public List<Country> searchCountryStartingWith(String alphabet) {
        return countryRepository.findByNameStartingWithIgnoreCase(alphabet);
    }

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}