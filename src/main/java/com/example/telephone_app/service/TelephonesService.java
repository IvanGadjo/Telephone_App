package com.example.telephone_app.service;

import java.util.List;

public interface TelephonesService {

    List<Integer> getAllTelephones();

    List<Integer> getAllMobilePhonesOfUser(String username);

    List<Integer> getAllHomePhonesOfUser(String username);

    void addMultipleTelephonesToUser(String username,List<Integer> telephones);
}
