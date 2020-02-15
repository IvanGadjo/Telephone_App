package com.example.telephone_app.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    String username;
                                            // ako vneses broj sto pocinja so 0 tuka se zacuvuva bez pocetnata 0,
                                            // no tuka se zacuvuva bez taa (bidejki integer)
    @ElementCollection
    @CollectionTable(name = "telephones")
    List<Integer> telephones;

    /*@OneToMany
    @JoinColumn(name = "user_id")           // todo: Mozebi tuka ne treba join coloumn
    List<User> contacts;*/


    public void initializeLists(){
        telephones=new ArrayList<>();
        //contacts=new ArrayList<>();
    }

    public void addTelephone(int newTelephone) {
        telephones.add(newTelephone);
    }

    /*public void addContact(User newContact){
        contacts.add(newContact);
    }

    public void removeContact(User removeContact){
        contacts.remove(removeContact);
    }*/
}
