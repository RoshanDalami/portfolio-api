package com.portfolio.api.rest.certificates.dao;

import com.portfolio.api.rest.certificates.dto.CertificateDTO;
import com.portfolio.api.rest.certificates.entity.Certificate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CertificateDAOJpaImplementation implements CertificateDAO {
    public EntityManager entityManager;

    public CertificateDAOJpaImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Certificate> findAll(){
        TypedQuery<Certificate> theQuery = entityManager.createQuery("from Certificate", Certificate.class);
        List<Certificate> certificates = theQuery.getResultList();
        return certificates;
    }

    @Override
    public Certificate findById(int id){
        Certificate certificate = entityManager.find(Certificate.class, id);
        return certificate;
    }

    @Override
    public void deleteById(int id){
        Certificate certificate = findById(id);
        entityManager.remove(certificate);
    }

    @Override
    public void save(CertificateDTO certificateDTO){
        Certificate newCertificate = new Certificate();
        newCertificate.setCertificateUrl(certificateDTO.getCertificateUrl());
        newCertificate.setGainedDate(certificateDTO.getGainedDate());
        newCertificate.setInstitution(certificateDTO.getInstitution());
        newCertificate.setTitle(certificateDTO.getTitle());
        newCertificate.setSkills(certificateDTO.getSkills());
        newCertificate.setImageUrl(certificateDTO.getImageUrl());
        entityManager.persist(newCertificate);
    }

    @Override
    public void update(CertificateDTO certificateDTO, int id){
        Certificate update = findById(id);
        update.setCertificateUrl(certificateDTO.getCertificateUrl());
        update.setGainedDate(certificateDTO.getGainedDate());
        update.setInstitution(certificateDTO.getInstitution());
        update.setTitle(certificateDTO.getTitle());
        update.setSkills(certificateDTO.getSkills());
        entityManager.merge(update);
    }
}
