package com.library.ormlearn;

import com.library.ormlearn.model.Department;
import com.library.ormlearn.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static DepartmentService departmentService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        departmentService = context.getBean(DepartmentService.class);

        Department department = departmentService.getDepartment(1);

        LOGGER.info("{}", department);

        department.getEmployeeList().forEach(employee ->
                LOGGER.info("{}", employee));
    }
}