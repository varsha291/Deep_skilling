package com.library.ormlearn;

import com.library.ormlearn.model.Employee;
import com.library.ormlearn.model.Skill;
import com.library.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static SkillService skillService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        skillService = context.getBean(SkillService.class);

        testGetSkill();
    }

    private static void testGetSkill() {

        LOGGER.info("Start");

        Skill skill = skillService.getSkill(1);

        LOGGER.info("Skill : {}", skill);

        for (Employee employee : skill.getEmployeeList()) {
            LOGGER.info("Employee : {}", employee);
        }

        LOGGER.info("End");
    }
}