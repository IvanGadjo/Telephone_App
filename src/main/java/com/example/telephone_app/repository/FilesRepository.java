package com.example.telephone_app.repository;

import com.example.telephone_app.model.DB_File;
import com.example.telephone_app.repository.jpa.FilesRepositortyJPA;
import org.springframework.stereotype.Repository;

@Repository
public class FilesRepository {

    FilesRepositortyJPA filesRepositortyJPA;

    public FilesRepository(FilesRepositortyJPA filesRepositortyJPA){
        this.filesRepositortyJPA = filesRepositortyJPA;
    }

    public DB_File storeFileInDB(DB_File db_file){
        return filesRepositortyJPA.save(db_file);
    }

    public DB_File findFileByIdInDB(int id){
        return filesRepositortyJPA.findById(id).orElseThrow(RuntimeException::new);
    }
}
