package com.portfolio.api.rest.certificates.service;

import com.portfolio.api.rest.certificates.dao.CertificateDAO;
import com.portfolio.api.rest.certificates.dto.CertificateDTO;
import com.portfolio.api.rest.certificates.entity.Certificate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImplementation implements CertificateService {

    public CertificateDAO certificateDAO;

    @Autowired
    public void setCertificateDAO(CertificateDAO certificateDAO){
        this.certificateDAO = certificateDAO;
    }

    @Override
    public List<Certificate> findAll(){
        return certificateDAO.findAll();
    }

    @Override
    public Certificate findById(int id){
        return certificateDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(CertificateDTO certificateDTO){
        certificateDAO.save(certificateDTO);
    }

    @Override
    @Transactional
    public void deleteById(int id){
        certificateDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void update(CertificateDTO certificateDTO, int id){
        certificateDAO.update(certificateDTO, id);
    }


}
