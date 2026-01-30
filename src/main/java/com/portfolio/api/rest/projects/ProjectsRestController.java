package com.portfolio.api.rest.projects;

import com.portfolio.api.rest.projects.dto.ProjectDTO;
import com.portfolio.api.rest.projects.entity.Projects;
import com.portfolio.api.rest.projects.service.ProjectService;
import com.portfolio.api.utils.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/projects")
@Tag(name = "Projects", description = "Endpoints for Projects Section")
public class ProjectsRestController {
    private ProjectService projectService;

    public ProjectsRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Projects>>> findAll(){
        List<Projects> projects = projectService.findAll();
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Projects fetched successfully", projects));
    }

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Objects>> save(@Valid @RequestBody ProjectDTO projectDTO){
        Projects projects = projectService.save(projectDTO);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED.value(), "Project created successfully", null));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> update(@RequestBody Projects projects, @PathVariable int id){
        Projects updatedProjects = projectService.update(projects, id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Project updated successfully", null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteById(@PathVariable int id){
        projectService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Project deleted successfully", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Projects>> findById(@PathVariable int id){
        Projects projects = projectService.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Project fetched successfully", projects));
    }
}
