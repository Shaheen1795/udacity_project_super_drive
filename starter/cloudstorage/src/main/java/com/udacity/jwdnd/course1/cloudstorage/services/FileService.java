package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private FileMapper fileMapper ;
    private SignUpService signUpService ;

    public FileService(FileMapper fileMapper,SignUpService signUpService) {
        this.fileMapper = fileMapper;
        this.signUpService = signUpService;
    }

    List<Files> getListOfAllFiles(Integer userId){
       return fileMapper.getListOfFiles(userId);
    }
;
    Integer createFile(Files files,Integer userId){
        files.setUserid(signUpService.getId());
        return fileMapper.createFile(files);
    }

    Files getFile(Integer fileId){
        return fileMapper.getFile(fileId);
    }

    Boolean editFile(Integer fileId,Files file){
        return  fileMapper.updateFile(fileId,file);
    }

    Integer deleteFile(Integer fileId){
        return fileMapper.deleteFile(fileId);
    }

}
