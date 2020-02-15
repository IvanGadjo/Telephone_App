package com.example.telephone_app.repository.jpa;

import com.example.telephone_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepositoryJPA extends JpaRepository<User, String> {


//    @Query("select c from ConsultationSlot c " +
//            "WHERE c.professor.firstName like :term or c.professor.lastName like :term")

    @Query("select u from User u " +
            "WHERE u.username like %:term%")
    List<User> searchUsers(@Param("term") String term);
}
