package com.experiment.TransferFileToDb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface IFileService {
    public boolean save(MultipartFile file);
}
