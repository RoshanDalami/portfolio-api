package com.portfolio.api.rest.experience;

import com.portfolio.api.rest.experience.dto.ExperienceDTO;
import com.portfolio.api.rest.experience.entity.Experience;
import com.portfolio.api.rest.experience.service.ExperienceService;
import com.portfolio.api.utils.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/experience")
@Tag(name = "Experience", description = "Endpoints for Experience Section")
@SecurityRequirement(name = "jwt-auth")
public class ExperienceRestController {

    public ExperienceService experienceService;

    public ExperienceRestController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Experience>>> findAll() {
        List<Experience> experiences = experienceService.findAll();
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Experience fetched successfully", experiences));
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> save(@Valid @RequestBody ExperienceDTO experienceDTO){
        Experience experience = experienceService.save(experienceDTO);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.CREATED.value(), "Experience created successfully", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Experience>> findById(@PathVariable int id){
        Experience experience = experienceService.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Experience fetched successfully", experience));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteById(@PathVariable int id){
        experienceService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Experience deleted successfully", null));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> update(@RequestBody Experience experience, @PathVariable int id){
        Experience updatedExperience = experienceService.update(experience, id);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Experience updated successfully", null));
    }


}
