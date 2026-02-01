package com.portfolio.api.filestorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {
    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties properties){
        this.fileStorageLocation =
                Paths.get("").toAbsolutePath().resolve("uploads").normalize();
        try{
            Files.createDirectories(fileStorageLocation);
        } catch (IOException e){
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", e);
        }
    }

    public String storeFile(MultipartFile file, String subFolder){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{

            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Path targetLocation = this.fileStorageLocation.resolve(subFolder).resolve(fileName);
            Files.createDirectories(targetLocation.getParent());

            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//            return targetLocation.toString();

            return subFolder + "/" + fileName;

        }catch (IOException e){
        throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }
    }
}
