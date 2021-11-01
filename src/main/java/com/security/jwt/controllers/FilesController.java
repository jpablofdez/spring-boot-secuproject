package com.security.jwt.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.security.jwt.message.ResponseMessage;
import com.security.jwt.models.FileData;
import com.security.jwt.models.FileInfo;
import com.security.jwt.models.Tutorial;
import com.security.jwt.models.User;
import com.security.jwt.payload.request.SignupRequest;
import com.security.jwt.repository.FileRepository;
import com.security.jwt.repository.UserRepository;
import com.security.jwt.service.FilesStorageService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class FilesController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;
	
  @Autowired
  FilesStorageService storageService;
  
  @Autowired
  FileRepository fileRp;
 
  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
    String message = "";
    try {
    	//save file
        storageService.save(file);
        
        // save in db
        FileData fileD = new FileData();
        //save the file in db
        System.out.println("File Name: " + file.getOriginalFilename());
        System.out.println("File Size: " + file.getSize()/1024+" Kb");
        System.out.println("File Type: " + file.getContentType());
        System.out.println("File Bytes: " + file.getBytes());
        
        User  user =  userRepository.findByEmailContaining(email);
        fileD.setName(file.getOriginalFilename());
        fileD.setFilesize(file.getSize()/1024+" Kb");
        fileD.setFletype(file.getContentType());
        fileD.setFileBytes(file.getBytes());
        
       // Users user01 = 
        fileD.setUsers(user);
        fileRp.save(fileD);
     
      
      message = "Uploaded the file successfully: " +  file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " +  file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
  @PostMapping("/upload1")
  public ResponseEntity<ResponseMessage> uploadFile1(@RequestParam("file") MultipartFile file,@RequestBody User currentUser) {
    String message = "";
    try {
    	//save file
      storageService.save(file);
      
      // save in db
      FileData fileD = new FileData();
      //save the file in db
      System.out.println("File Name: " + file.getOriginalFilename());
      System.out.println("File Size: " + file.getSize()/1024+" Kb");
      System.out.println("File Type: " + file.getContentType());
      System.out.println("File Bytes: " + file.getBytes());
      fileD.setName(file.getOriginalFilename());
      fileD.setFilesize(file.getSize()/1024+" Kb");
      fileD.setFletype(file.getContentType());
      fileD.setFileBytes(file.getBytes());
      
     // Users user01 = 
     // fileD.setUsers(user);
      fileRp.save(fileD);
      
      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
  @GetMapping("/files")
  public ResponseEntity<List<FileInfo>> getListFiles() {
    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
      String filename = path.getFileName().toString();
      String url = MvcUriComponentsBuilder
          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

      return new FileInfo(filename, url);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
  }

  @GetMapping("/files/{filename:.+}")
  @ResponseBody
  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    Resource file = storageService.load(filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }
}