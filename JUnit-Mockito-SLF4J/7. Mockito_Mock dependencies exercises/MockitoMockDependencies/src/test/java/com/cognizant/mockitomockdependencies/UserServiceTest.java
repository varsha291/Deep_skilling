package com.cognizant;

import com.cognizant.entity.User;
import com.cognizant.repository.UserRepository;
import com.cognizant.service.UserService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    void testGetUserById() {

        UserRepository userRepository =
                mock(UserRepository.class);

        User user = new User(1L, "Ishu");

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        UserService userService =
                new UserService(userRepository);

        User result =
                userService.getUserById(1L);

        assertEquals("Ishu", result.getName());
    }
}