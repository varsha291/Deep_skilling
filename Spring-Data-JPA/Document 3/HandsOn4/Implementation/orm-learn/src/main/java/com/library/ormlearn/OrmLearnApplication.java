package com.library.ormlearn;

import com.library.ormlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);

        testGetAverageSalary();
    }

    private static void testGetAverageSalary() {

        LOGGER.info("Start");

        Double averageSalary = employeeService.getAverageSalary();

        LOGGER.info("Average Salary : {}", averageSalary);

        LOGGER.info("End");
    }
}