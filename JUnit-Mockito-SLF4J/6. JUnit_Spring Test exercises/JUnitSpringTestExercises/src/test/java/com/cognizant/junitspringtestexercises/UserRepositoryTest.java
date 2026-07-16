package com.cognizant;

import com.cognizant.entity.User;
import com.cognizant.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {
        User user = new User();
        user.setName("Ishu");

        userRepository.save(user);

        List<User> users =
                userRepository.findByName("Ishu");

        assertEquals(1, users.size());
    }
}