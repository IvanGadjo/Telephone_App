package com.example.telephone_app.service;

import com.example.telephone_app.model.DB_File;
import org.springframework.web.multipart.MultipartFile;

public interface FilesService {

    DB_File storeFile(MultipartFile file);

    DB_File getFile(int fileId);
}
