package com.portfolio.api.rest.certificates.dao;

import com.portfolio.api.rest.certificates.dto.CertificateDTO;
import com.portfolio.api.rest.certificates.entity.Certificate;

import java.util.List;

public interface CertificateDAO {

    List<Certificate> findAll();
    Certificate findById(int id);
    void save(CertificateDTO certificateDTO);
    void deleteById(int id);
    void update(CertificateDTO certificateDTO, int id);
}
