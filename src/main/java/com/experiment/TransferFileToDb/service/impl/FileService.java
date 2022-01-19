package com.experiment.TransferFileToDb.service.impl;

import com.experiment.TransferFileToDb.datamodel.Tutorial;
import com.experiment.TransferFileToDb.datarepository.TutorialRepository;
import com.experiment.TransferFileToDb.helper.ExcelHelper;
import com.experiment.TransferFileToDb.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService implements IFileService {
    @Autowired
    TutorialRepository tutorialRepository;
    public boolean save(MultipartFile file)  {


        try {
            List<Tutorial> tutorialList = ExcelHelper.excelToTutotial(file.getInputStream());
            tutorialRepository.saveAll(tutorialList);
            System.out.println("data saved successfully");
            return true;
        }
        catch(Exception e){
            System.out.println("exception occured while storing tutorial data"+e);
            return false;
        }

    }
}
