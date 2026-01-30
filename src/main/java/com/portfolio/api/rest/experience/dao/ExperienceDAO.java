package com.portfolio.api.rest.experience.dao;

import com.portfolio.api.rest.experience.dto.ExperienceDTO;
import com.portfolio.api.rest.experience.entity.Experience;

import java.util.List;

public interface ExperienceDAO {
    List<Experience> findAll();
    Experience findById(int id);
    Experience save(ExperienceDTO experienceDTO);
    void deleteById(int id);
    Experience update(Experience experience, int id);



}
