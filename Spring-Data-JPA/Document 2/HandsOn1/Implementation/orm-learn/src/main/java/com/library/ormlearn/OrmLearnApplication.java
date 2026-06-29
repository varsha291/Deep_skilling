package com.library.ormlearn;

import com.library.ormlearn.model.Country;
import com.library.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);

        testSearchCountry();
        testSearchCountrySorted();
        testSearchCountryStartingWith();
    }

    private static void testSearchCountry() {

        LOGGER.info("Search Country");

        List<Country> countries = countryService.searchCountry("ou");

        countries.forEach(country -> LOGGER.debug("{}", country));
    }

    private static void testSearchCountrySorted() {

        LOGGER.info("Search Country Sorted");

        List<Country> countries = countryService.searchCountrySorted("ou");

        countries.forEach(country -> LOGGER.debug("{}", country));
    }

    private static void testSearchCountryStartingWith() {

        LOGGER.info("Search Country Starting With");

        List<Country> countries = countryService.searchCountryStartingWith("Z");

        countries.forEach(country -> LOGGER.debug("{}", country));
    }
}