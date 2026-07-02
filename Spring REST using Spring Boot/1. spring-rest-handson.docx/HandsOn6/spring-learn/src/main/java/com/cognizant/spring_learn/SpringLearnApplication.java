package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringLearnApplication.class, args);

		displayCountries();
	}

	public static void displayCountries() {

		LOGGER.info("START");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		ArrayList<Country> countryList =
				context.getBean("countryList", ArrayList.class);

		LOGGER.debug("Countries : {}", countryList);

		LOGGER.info("END");
	}
}