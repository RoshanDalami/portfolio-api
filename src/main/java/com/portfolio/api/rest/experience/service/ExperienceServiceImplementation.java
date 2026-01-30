package com.portfolio.api.rest.experience.service;

import com.portfolio.api.rest.experience.dao.ExperienceDAO;
import com.portfolio.api.rest.experience.dto.ExperienceDTO;
import com.portfolio.api.rest.experience.entity.Experience;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImplementation implements ExperienceService {

    private ExperienceDAO experienceDAO;

    @Autowired
    public void setExperienceDAo(ExperienceDAO experienceDAO){
        this.experienceDAO = experienceDAO;
    }

    @Override
    public List<Experience> findAll(){
        return experienceDAO.findAll();
    }

    @Override
    public Experience findById(int id){
        return experienceDAO.findById(id);
    }

    @Transactional
    @Override
    public Experience save(ExperienceDTO experienceDTO){
        Experience experience = experienceDAO.save(experienceDTO);
        return experience;
    }

    @Transactional
    @Override
    public Experience update(Experience experience, int id){
        Experience updated = experienceDAO.update(experience, id);
        return updated;
    }

    @Transactional
    @Override
    public void deleteById(int id){
        experienceDAO.deleteById(id);
    }

}
