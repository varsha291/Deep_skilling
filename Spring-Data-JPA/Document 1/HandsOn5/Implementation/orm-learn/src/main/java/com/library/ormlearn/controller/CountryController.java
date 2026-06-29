package com.library.ormlearn.controller;

import com.library.ormlearn.model.Country;
import com.library.ormlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/{code}")
    public String deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
        return "Country Deleted Successfully!";
    }

    @GetMapping("/search/{name}")
    public List<Country> searchCountry(@PathVariable String name) {
        return countryService.searchCountry(name);
    }
}