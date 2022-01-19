package com.experiment.TransferFileToDb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.experiment.TransferFileToDb.service.IFileService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file/*")
public class FileController {
    @Autowired
    IFileService fileService;
    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }
    @PostMapping("/uploadFile")
    public  Map<String,Object> uploadFile(@RequestParam("file") MultipartFile file)  {
        Map<String,Object> result=new HashMap<>();
       // MultipartFile file= (MultipartFile) requestBody.get("file");
        boolean isFileSaved=fileService.save(file);
        if(isFileSaved) {
            System.out.println("data saved successfully");
            result.put("result","data saved sucessfully");
            result.put("error",!isFileSaved);
        }
        else{
            if(isFileSaved) {
                System.out.println("data not saved successfully");
                result.put("result","data not saved sucessfully");
                result.put("error",isFileSaved);
            }
        }

    return result;
    }
}
