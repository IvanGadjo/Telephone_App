package com.example.telephone_app.service.impl;

import com.example.telephone_app.model.User;
import com.example.telephone_app.repository.UsersRepository;
import com.example.telephone_app.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }

    @Override
    public void fillDatabaseAtStart(){
        usersRepository.fillDatabaseAtStart();
    }

    @Override
    public List<User> searchUsers(String term) {
        return usersRepository.searchUsers(term);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.getAllUsers();
    }

    @Override
    public void removeUser(User user) {
        usersRepository.removeUser(user);
    }

    @Override
    public void addUser(User user) {
        usersRepository.addUser(user);
    }

    @Override
    public void addTelephoneToUser(String username, int telephone) {
        usersRepository.addTelephoneToUser(username,telephone);
    }

    @Override
    public User getUserByUsername(String username) {
        return usersRepository.getUserByUsername(username);
    }
}
