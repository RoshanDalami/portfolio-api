package com.portfolio.api.rest.certificates.service;

import com.portfolio.api.rest.certificates.dto.CertificateDTO;
import com.portfolio.api.rest.certificates.entity.Certificate;

import java.util.List;

public interface CertificateService {
    List<Certificate> findAll();
    Certificate findById(int id);
    void save(CertificateDTO certificateDTO);
    void deleteById(int id);
    void update(CertificateDTO certificateDTO, int id);
}
