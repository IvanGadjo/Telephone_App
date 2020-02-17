package com.example.telephone_app.repository.jpa;

import com.example.telephone_app.model.DB_File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepositortyJPA extends JpaRepository<DB_File,Integer> {
}
