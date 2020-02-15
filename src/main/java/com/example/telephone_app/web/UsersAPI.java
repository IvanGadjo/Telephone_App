package com.example.telephone_app.web;

import com.example.telephone_app.model.User;
import com.example.telephone_app.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/users", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class UsersAPI {

    UsersService usersService;

    public UsersAPI(UsersService usersService){
        this.usersService=usersService;
    }

    @GetMapping
    public List<User> getAllUsers(){

        usersService.fillDatabaseAtStart();

        return usersService.getAllUsers();
    }

    @GetMapping(params = "term")
    public List<User> searchUsers(@RequestParam String term){
        return usersService.searchUsers(term);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable("id") String username){
        User user = usersService.getUserByUsername(username);
        usersService.removeUser(user);
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user){
        user.initializeLists();
        usersService.addUser(user);
    }



    // todo: Move to telephonesAPI

    @PutMapping("/{id}")
    public void addTelephoneToUser(@PathVariable("id") String username,
                                   @RequestParam("telephone") int newTelephone){
        usersService.addTelephoneToUser(username,newTelephone);
    }




    @GetMapping("/{id}")
    public User getUserByUsername(@PathVariable("id") String username){
        return usersService.getUserByUsername(username);
    }
}
