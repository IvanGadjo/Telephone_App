package com.example.telephone_app.repository;

import com.example.telephone_app.dataholder.Dataholder;
import com.example.telephone_app.model.User;
import com.example.telephone_app.repository.jpa.UsersRepositoryJPA;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsersRepository {

    Dataholder dataholder;

    // treba samo ova da go ima na kraj, bez dataholder
    UsersRepositoryJPA usersRepositoryJPA;

    public UsersRepository(Dataholder dataholder, UsersRepositoryJPA usersRepositoryJPA){
        this.dataholder=dataholder;
        this.usersRepositoryJPA=usersRepositoryJPA;

    }

    public void fillDatabaseAtStart(){
        if(this.usersRepositoryJPA.count()==0){
            this.usersRepositoryJPA.saveAll(dataholder.getListUsers());
            System.out.println("Added the users to the DB");
        }
        System.out.println("The users are already in the DB");

    }

    public List<User> getAllUsers(){
        //return dataholder.getListUsers();
        return usersRepositoryJPA.findAll();
    }

    public void removeUser(User user){
        //dataholder.getListUsers().remove(user);
        usersRepositoryJPA.delete(user);
    }

    public void addUser(User user){
        //dataholder.getListUsers().add(user);
        usersRepositoryJPA.save(user);
    }

    public void addTelephoneToUser(String username,int telephone){
//        User user = dataholder.getListUsers().stream().filter(u -> {
//            return u.getUsername().equals(username);
//        }).findFirst().orElseThrow(RuntimeException::new);
//
//        user.addTelephone(telephone);
        User user = usersRepositoryJPA.getOne(username);
        user.addTelephone(telephone);
        usersRepositoryJPA.save(user);
    }

    public User getUserByUsername(String username){
//        return dataholder.getListUsers().stream().filter(u -> {
//            return u.getUsername().equals(username);
//        }).findFirst().orElseThrow(RuntimeException::new);
        List<User> users = usersRepositoryJPA.findAll();

        List<String> usernames = new ArrayList<>();
        users.stream().forEach(u ->{
            usernames.add(u.getUsername());
        });

        User user = new User();
        if(usernames.contains(username)){
            user = usersRepositoryJPA.getOne(username);
        }
        else{
            System.out.println("Vo databazata nema takov user");
        }

        return user;
    }

    public List<User> searchUsers(String term){
        List<User> users = usersRepositoryJPA.searchUsers(term);
        return users;
    }



    // TELEPHONES:

    public List<Integer> getAllTelephones(){
        List<Integer> telephones = this.usersRepositoryJPA.findAll().stream().map(usr -> usr.getTelephones())
                .flatMap(List::stream).collect(Collectors.toList());

        return telephones;
    }

    public List<Integer> getAllMobilePhonesOfUser(String username){
        User user = getUserByUsername(username);
        List<Integer> mobilePhones = user.getTelephones().stream().map(t -> t.toString())
                .filter(s -> s.startsWith("7")).map(st -> Integer.parseInt(st)).collect(Collectors.toList());

        return mobilePhones;
    }

    public List<Integer> getAllHomePhonesOfUser(String username){
        User user = getUserByUsername(username);
        List<Integer> homePhones = user.getTelephones().stream().map(t -> t.toString())
                .filter(s -> s.startsWith("2")).map(st -> Integer.parseInt(st)).collect(Collectors.toList());

        return homePhones;
    }

    public void addMultipleTelephonesToUser(String username,List<Integer> telephones){
        telephones.stream().forEach(t -> {
            this.addTelephoneToUser(username,t);
        });
    }
}
