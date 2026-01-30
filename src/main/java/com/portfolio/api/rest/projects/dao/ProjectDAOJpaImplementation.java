package com.portfolio.api.rest.projects.dao;

import com.portfolio.api.rest.projects.dto.ProjectDTO;
import com.portfolio.api.rest.projects.entity.Projects;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAOJpaImplementation implements ProjectDAO {
    private EntityManager entityManager;
    public ProjectDAOJpaImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Projects> findAll(){
        TypedQuery<Projects> theQuery = entityManager.createQuery("from Projects", Projects.class);
        List<Projects> projects = theQuery.getResultList();
        return projects;
    }

    @Override
    public Projects findById(int id){
        Projects project = entityManager.find(Projects.class, id);
        return project;
    }

    @Override
    public Projects save(ProjectDTO projectDTO){
        Projects project = new Projects();
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());
        project.setThumbnail(projectDTO.getThumbnail());
        project.setGithubLink(projectDTO.getGithubLink());
        project.setLiveLink(projectDTO.getLiveLink());
        project.setTechUsed(projectDTO.getTechUsed());

        entityManager.persist(project);
        return project;
    }

    @Override
    public Projects update(Projects project, int id){
        Projects existingProject = findById(id);
        existingProject.setTitle(project.getTitle());
        existingProject.setDescription(project.getDescription());
        existingProject.setThumbnail(project.getThumbnail());
        existingProject.setGithubLink(project.getGithubLink());
        existingProject.setLiveLink(project.getLiveLink());
        existingProject.setTechUsed(project.getTechUsed());
        entityManager.merge(existingProject);
        return existingProject;
    }

    @Override
    public void deleteById(int id){
        Projects project = findById(id);
        entityManager.remove(project);
    }

}
