package com.portfolio.api.rest.experience.dao;

import com.portfolio.api.rest.experience.dto.ExperienceDTO;
import com.portfolio.api.rest.experience.entity.Experience;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExperienceDAOJpaImplementation implements ExperienceDAO{
    private EntityManager entityManager;

    @Autowired
    public ExperienceDAOJpaImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Experience> findAll() {
        TypedQuery<Experience> theQuery = entityManager.createQuery("from Experience", Experience.class);
        List<Experience> experiences = theQuery.getResultList();
        return experiences;
    }

    @Override
    public Experience findById(int id) {
        Experience experience = entityManager.find(Experience.class, id);
        return experience;
    }

    @Override
    public void deleteById(int id){
        Experience experience = findById(id);
        entityManager.remove(experience);
    }

    @Override
    public Experience save(ExperienceDTO experienceDTO){
        Experience experience = new Experience();
        experience.setCompanyName(experienceDTO.getCompanyName());
        experience.setStart(experienceDTO.getStart());
        experience.setEnd(experienceDTO.getEnd());
        experience.setPosition(experienceDTO.getPosition());
        experience.setDescription(experienceDTO.getDescription());
        entityManager.persist(experience);
        return experience;
    }

    @Override
    public Experience update(Experience experience, int id){
        Experience existingExperience = findById(id);
        existingExperience.setCompanyName(experience.getCompanyName());
        existingExperience.setStart(experience.getStart());
        existingExperience.setEnd(experience.getEnd());
        existingExperience.setPosition(experience.getPosition());
        existingExperience.setDescription(experience.getDescription());

        return entityManager.merge(existingExperience);
    }

}
