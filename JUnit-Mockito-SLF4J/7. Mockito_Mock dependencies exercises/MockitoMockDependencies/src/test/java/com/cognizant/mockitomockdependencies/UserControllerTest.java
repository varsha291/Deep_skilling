package com.cognizant;

import com.cognizant.controller.UserController;
import com.cognizant.entity.User;
import com.cognizant.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Test
    void testGetUser() {

        UserService userService =
                mock(UserService.class);

        User user = new User(1L, "Ishu");

        when(userService.getUserById(1L))
                .thenReturn(user);

        UserController controller =
                new UserController(userService);

        User result = controller
                .getUser(1L)
                .getBody();

        assertEquals("Ishu", result.getName());
    }
}