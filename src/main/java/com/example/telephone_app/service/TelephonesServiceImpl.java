package com.example.telephone_app.service;

import com.example.telephone_app.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelephonesServiceImpl implements TelephonesService {

    UsersRepository usersRepository;

    public TelephonesServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Integer> getAllTelephones() {
        return usersRepository.getAllTelephones();
    }

    @Override
    public List<Integer> getAllMobilePhonesOfUser(String username) {
        return usersRepository.getAllMobilePhonesOfUser(username);
    }

    @Override
    public List<Integer> getAllHomePhonesOfUser(String username) {
        return usersRepository.getAllHomePhonesOfUser(username);
    }

    @Override
    public void addMultipleTelephonesToUser(String username, List<Integer> telephones) {
        usersRepository.addMultipleTelephonesToUser(username,telephones);
    }
}
