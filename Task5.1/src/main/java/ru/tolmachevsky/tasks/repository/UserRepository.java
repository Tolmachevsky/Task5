package ru.tolmachevsky.tasks.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tolmachevsky.tasks.model.User;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}