package com.example.telephone_app.web;

import com.example.telephone_app.model.DB_File;
import com.example.telephone_app.model.UploadFileResponse;
import com.example.telephone_app.service.FilesService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


        // Todo: -- unfinished --



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/files", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class FilesAPI {

    FilesService filesService;

    public FilesAPI(FilesService filesService){
        this.filesService = filesService;
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file")MultipartFile file){
        DB_File db_file = filesService.storeFile(file);
                                        // todo: Ova moze da e frka, razlicno mi e od kaj niv
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/").path(Integer.toString(db_file.getId())).toUriString();

        return new UploadFileResponse(db_file.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fileId") Integer fileId){
        DB_File db_file = filesService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(db_file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + db_file.getFileName() + "\"")
                .body(new ByteArrayResource(db_file.getData()));
    }
}
