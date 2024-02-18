package ru.shadrag.hw10.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.shadrag.hw10.model.User;
import ru.shadrag.hw10.repositories.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestAuthService {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegistrationUser() {
        User user = new User();
        authService.registerUser(user);

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    public void testLogoutUser() {
        Long id = 1L;
        authService.logoutUser(id);

        Mockito.verify(userRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testFindUserByEmail() {
        User mockUser = new User();
        mockUser.setUsername("user");
        mockUser.setPassword("userpass");

        when(userRepository.findUserByUsername("user")).thenReturn(Optional.of(mockUser));

        User foundUser = authService.loginUser("user", "userpass");

        assertEquals(mockUser, foundUser);
    }


}
