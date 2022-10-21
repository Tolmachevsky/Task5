package ru.tolmachevsky.tasks.service;


import ru.tolmachevsky.tasks.model.User;

public interface UserService {
    void save(User user);

    Iterable<User> findAll();

    User findById(Integer id);

    void deleteUserById(Integer id);

    User findByEmail(String email);

}