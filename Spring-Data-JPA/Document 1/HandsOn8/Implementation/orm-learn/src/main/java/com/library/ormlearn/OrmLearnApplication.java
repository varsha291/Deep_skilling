package com.library.ormlearn;

import com.library.ormlearn.model.Country;
import com.library.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);

        testUpdateCountry();
    }

    private static void testUpdateCountry() {

        LOGGER.info("Start");

        Country country = new Country("IN", "India Updated");

        countryService.updateCountry(country);

        LOGGER.info("Country Updated Successfully");

        LOGGER.info("End");
    }
}