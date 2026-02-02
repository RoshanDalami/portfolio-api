package com.portfolio.api.rest.projects;

import com.portfolio.api.decorators.PublicValidator;
import com.portfolio.api.filestorage.FileStorageService;
import com.portfolio.api.rest.projects.dto.ProjectDTO;
import com.portfolio.api.rest.projects.entity.Projects;
import com.portfolio.api.rest.projects.service.ProjectService;
import com.portfolio.api.utils.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/v1/projects")
@Tag(name = "Projects", description = "Endpoints for Projects Section")
@SecurityRequirement(name = "jwt-auth")
public class ProjectsRestController {
    private ProjectService projectService;
private FileStorageService fileStorageService;
    private static final Logger logger =
            LoggerFactory.getLogger(ProjectsRestController.class);
    public ProjectsRestController(ProjectService projectService, FileStorageService fileStorageService) {
        this.projectService = projectService;
        this.fileStorageService = fileStorageService;
    }

    @PublicValidator()
    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Projects>>> findAll(){
        List<Projects> projects = projectService.findAll();
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Projects fetched successfully", projects));
    }

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Objects>> save(@Valid @ModelAttribute ProjectDTO projectDTO){
        logger.atInfo().log(projectDTO.toString(),"project Dto");
        String imageUrl = this.fileStorageService.storeFile(projectDTO.getThumbnailFile(),"projects");
        projectDTO.setThumbnail(imageUrl);
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

    @PublicValidator
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Projects>> findById(@PathVariable int id){
        Projects projects = projectService.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Project fetched successfully", projects));
    }
}
