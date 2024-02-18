package ru.shadrag.hw10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shadrag.hw10.model.User;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
