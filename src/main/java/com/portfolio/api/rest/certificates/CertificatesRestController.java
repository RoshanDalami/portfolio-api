package com.portfolio.api.rest.certificates;


import com.portfolio.api.filestorage.FileStorageService;
import com.portfolio.api.rest.certificates.dto.CertificateDTO;
import com.portfolio.api.rest.certificates.entity.Certificate;
import com.portfolio.api.rest.certificates.service.CertificateService;
import com.portfolio.api.utils.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/certificate")
@Tag(name = "Certificates")
public class CertificatesRestController {
    public CertificateService certificateService;
    public FileStorageService fileStorageService;

    final public Logger logger = LoggerFactory.getLogger(CertificatesRestController.class);

    public CertificatesRestController(CertificateService certificateService, FileStorageService fileStorageService){
        this.certificateService = certificateService;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<Certificate>>> findAll(){
        List<Certificate> certificates = this.certificateService.findAll();
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Certificates fetched successfully",
                certificates));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Object>> save(@ModelAttribute CertificateDTO certificateDTO){

        String certificateURL = this.fileStorageService.storeFile(certificateDTO.getCertificateFile(),"certificates");
        this.logger.info("Certificate URL: {}", certificateURL);
        certificateDTO.setImageUrl(certificateURL);
        this.certificateService.save(certificateDTO);
       return ResponseEntity.created((null)).body(new ApiResponse<>(HttpStatus.CREATED.value(), "Certificate created " +
               "successfully", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Certificate>> findById(@PathVariable int id){
        Certificate certificate = this.certificateService.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Certificate fetched successfully", certificate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteById(@PathVariable int id){
        this.certificateService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Certificate deleted successfully", null));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> update( @RequestBody CertificateDTO certificateDTO, @PathVariable int id){
        this.certificateService.update(certificateDTO, id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Certificate updated successfully", null));
    }


}
