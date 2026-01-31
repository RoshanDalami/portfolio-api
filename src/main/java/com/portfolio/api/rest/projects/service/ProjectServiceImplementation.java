package com.portfolio.api.rest.projects.service;

import com.portfolio.api.rest.projects.dao.ProjectDAO;
import com.portfolio.api.rest.projects.dto.ProjectDTO;
import com.portfolio.api.rest.projects.entity.Projects;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImplementation implements ProjectService {
    private ProjectDAO projectDAO;

    @Autowired
    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public List<Projects> findAll(){
        return projectDAO.findAll();
    }

    @Override
    public Projects findById(int id){
        return projectDAO.findById(id);
    }

    @Transactional
    @Override
    public Projects save(ProjectDTO projectDTO){
        Projects project = projectDAO.save(projectDTO);
        return project;
    }

    @Transactional
    @Override
    public void deleteById(int id){
        projectDAO.deleteById(id);
    }

    @Transactional
    @Override
    public Projects update(Projects project, int id){
        Projects updated = projectDAO.update(project, id);
        return updated;
    }

}
