package com.example.telephone_app.service.impl;

import com.example.telephone_app.model.DB_File;
import com.example.telephone_app.repository.FilesRepository;
import com.example.telephone_app.service.FilesService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FilesServiceImpl implements FilesService {

    FilesRepository filesRepository;

    public FilesServiceImpl(FilesRepository filesRepository){
        this.filesRepository = filesRepository;
    }

    @Override
    public DB_File storeFile(MultipartFile file) {

        // Normalize filename
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());


        if(fileName.contains("..")){
            System.out.println("!! Filename contains invalid path sequence !!");
        }
        DB_File db_file = null;
        try {
            db_file = new DB_File(fileName,file.getContentType(),file.getBytes());
        } catch (IOException e) {
            System.out.println("!!  Could not store file !!");
        }
        return filesRepository.storeFileInDB(db_file);

    }

    @Override
    public DB_File getFile(int fileId) {
        return filesRepository.findFileByIdInDB(fileId);
    }
}
