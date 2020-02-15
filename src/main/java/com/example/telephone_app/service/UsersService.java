package com.example.telephone_app.service;

import com.example.telephone_app.model.User;

import java.util.List;

public interface UsersService {

    List<User> getAllUsers();

    void removeUser(User user);

    void addUser(User user);

    void addTelephoneToUser(String username, int telephone);

    User getUserByUsername(String username);

    void fillDatabaseAtStart();

    List<User> searchUsers(String term);
}
