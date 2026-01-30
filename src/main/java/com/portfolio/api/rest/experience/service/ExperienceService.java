package com.portfolio.api.rest.experience.service;

import com.portfolio.api.rest.experience.dto.ExperienceDTO;
import com.portfolio.api.rest.experience.entity.Experience;

import java.util.List;

public interface ExperienceService {
    List<Experience> findAll();
    Experience findById(int id);
    Experience save(ExperienceDTO experience);
    void deleteById(int id);
    Experience update(Experience experience, int id);
}
