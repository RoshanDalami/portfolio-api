package com.portfolio.api.rest.projects.dao;

import com.portfolio.api.rest.projects.dto.ProjectDTO;
import com.portfolio.api.rest.projects.entity.Projects;

import java.util.List;

public interface ProjectDAO {
    List<Projects> findAll();
    Projects findById(int id);
    Projects save(ProjectDTO projects);
    void deleteById(int id);
    Projects update(Projects projects, int id);
}
