package com.cognizant;

import com.cognizant.entity.User;
import com.cognizant.repository.UserRepository;
import com.cognizant.service.UserService;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void testGetUserById() {
        UserRepository repository = mock(UserRepository.class);

        User user = new User(1L, "Ishu");

        when(repository.findById(1L))
                .thenReturn(Optional.of(user));

        UserService service = new UserService(repository);

        User result = service.getUserById(1L);

        assertEquals("Ishu", result.getName());
    }

    @Test
    void testMissingUser() {
        UserRepository repository = mock(UserRepository.class);

        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        UserService service = new UserService(repository);

        assertThrows(
                NoSuchElementException.class,
                () -> service.getUserById(1L)
        );
    }
}