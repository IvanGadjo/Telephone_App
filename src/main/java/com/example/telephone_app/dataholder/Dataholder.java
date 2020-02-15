package com.example.telephone_app.dataholder;

import com.example.telephone_app.model.User;
import com.example.telephone_app.repository.jpa.UsersRepositoryJPA;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class Dataholder {

    List<User> listUsers;
    //UsersRepositoryJPA usersRepositoryJPA;

    public Dataholder(UsersRepositoryJPA usersRepositoryJPA){

        // Dependency injection - database
        //this.usersRepositoryJPA=usersRepositoryJPA;

        listUsers = new ArrayList<>();

        generateUsers();

        //addUsersToDB();
    }

    public void generateUsers(){
//        User user1 = new User("User eins",new ArrayList<>(),new ArrayList<>());
//        User user2 = new User("User zwei",new ArrayList<>(),new ArrayList<>());
//        User user3 = new User("User drei",new ArrayList<>(),new ArrayList<>());
//        User user4 = new User("User vier",new ArrayList<>(),new ArrayList<>());
//        User user5 = new User("User funf",new ArrayList<>(),new ArrayList<>());
//        User user6 = new User("User sechs",new ArrayList<>(),new ArrayList<>());

        User user1 = new User("User eins",new ArrayList<>());
        User user2 = new User("User zwei",new ArrayList<>());
        User user3 = new User("User drei",new ArrayList<>());
        User user4 = new User("User vier",new ArrayList<>());
        User user5 = new User("User funf",new ArrayList<>());
        User user6 = new User("User sechs",new ArrayList<>());


        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        listUsers.add(user4);
        listUsers.add(user5);
        listUsers.add(user6);

        user1.addTelephone(071);
        user2.addTelephone(072);
        user3.addTelephone(073);
        user4.addTelephone(074);
        user5.addTelephone(075);
        user6.addTelephone(076);

//        user1.addContact(user2);
//        user1.addContact(user3);
//        user2.addContact(user3);
    }

//    public void addUsersToDB(){
//
//
//        if(this.usersRepositoryJPA.count()==0){
//            this.usersRepositoryJPA.saveAll(listUsers);
//            System.out.println("Added the users to the DB");
//        }
//        System.out.println("The users are already in the DB");
//    }

}
