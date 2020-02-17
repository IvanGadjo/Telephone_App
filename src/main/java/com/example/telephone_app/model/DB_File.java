package com.example.telephone_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "files")
@NoArgsConstructor
@Data
public class DB_File {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String fileName;

    String fileType;

    byte[] data;

    public DB_File(String fileName, String fileType, byte[] data){
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
}
