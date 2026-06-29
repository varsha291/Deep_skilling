package com.library.ormlearn.controller;

import com.library.ormlearn.model.Country;
import com.library.ormlearn.service.CountryService;
import com.library.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // Get All Countries
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    // Hands-on 6
    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        return countryService.findCountryByCode(code);
    }

    // Hands-on 7
    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    // Hands-on 8
    @PutMapping
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }

    // Hands-on 9
    @DeleteMapping("/{code}")
    public String deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
        return "Country Deleted Successfully!";
    }

    // Search Country
    @GetMapping("/search/{name}")
    public List<Country> searchCountry(@PathVariable String name) {
        return countryService.searchCountry(name);
    }
}