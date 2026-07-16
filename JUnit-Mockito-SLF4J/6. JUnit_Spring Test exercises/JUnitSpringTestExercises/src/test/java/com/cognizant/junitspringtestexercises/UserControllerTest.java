package com.cognizant;

import com.cognizant.controller.UserController;
import com.cognizant.entity.User;
import com.cognizant.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Test
    void testGetUser() {
        UserService service = mock(UserService.class);

        User user = new User(1L, "Ishu");

        when(service.getUserById(1L))
                .thenReturn(user);

        UserController controller =
                new UserController(service);

        ResponseEntity<User> response =
                controller.getUser(1L);

        assertEquals("Ishu",
                response.getBody().getName());
    }

    @Test
    void testCreateUser() {
        UserService service = mock(UserService.class);

        User user = new User(1L, "Ishu");

        when(service.saveUser(user))
                .thenReturn(user);

        UserController controller =
                new UserController(service);

        ResponseEntity<User> response =
                controller.createUser(user);

        assertEquals("Ishu",
                response.getBody().getName());
    }
}