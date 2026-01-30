package com.portfolio.api.rest.projects.service;

import com.portfolio.api.rest.projects.dto.ProjectDTO;
import com.portfolio.api.rest.projects.entity.Projects;

import java.util.List;

public interface ProjectService {
    List<Projects> findAll();
    Projects findById(int id);
    Projects save(ProjectDTO projects);
    void deleteById(int id);
    Projects update(Projects projects, int id);
}
