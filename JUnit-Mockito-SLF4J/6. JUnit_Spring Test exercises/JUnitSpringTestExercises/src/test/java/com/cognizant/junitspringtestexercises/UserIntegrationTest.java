package com.cognizant;

import com.cognizant.entity.User;
import com.cognizant.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = JUnitSpringTestExercisesApplication.class)
public class UserIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFullFlow() {
        User user = new User();
        user.setName("Ishu");

        User savedUser = userRepository.save(user);

        User result = userRepository
                .findById(savedUser.getId())
                .orElseThrow();

        assertEquals("Ishu", result.getName());
    }
}