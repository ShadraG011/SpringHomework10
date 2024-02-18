package ru.shadrag.hw10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shadrag.hw10.model.User;
import ru.shadrag.hw10.repositories.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findUserByUsername(username).stream().findFirst().orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found: " + username);
        } else if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    public User logoutUser(Long userId) {
        return userRepository.findById(userId).stream().findFirst().orElse(null);
    }
}
