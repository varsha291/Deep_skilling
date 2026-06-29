package com.library.ormlearn;

import com.library.ormlearn.model.Attempt;
import com.library.ormlearn.model.AttemptOption;
import com.library.ormlearn.model.AttemptQuestion;
import com.library.ormlearn.model.Options;
import com.library.ormlearn.service.AttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static AttemptService attemptService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        attemptService = context.getBean(AttemptService.class);

        testGetAttempt();
    }

    private static void testGetAttempt() {

        LOGGER.info("Start");

        Attempt attempt = attemptService.getAttempt(1, 1);

        LOGGER.info("Username : {}", attempt.getUser().getUsername());
        LOGGER.info("Attempt Date : {}", attempt.getAttemptedDate());

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {

            LOGGER.info("-----------------------------------");
            LOGGER.info("Question : {}", aq.getQuestion().getQuestionText());

            for (Options option : aq.getQuestion().getOptions()) {

                boolean selected = false;

                for (AttemptOption ao : aq.getAttemptOptions()) {
                    if (ao.getOption().getId() == option.getId()) {
                        selected = true;
                        break;
                    }
                }

                LOGGER.info("{} | Score : {} | Selected : {}",
                        option.getOptionText(),
                        aq.getQuestion().getScore(),
                        selected);
            }
        }

        LOGGER.info("End");
    }
}