package com.portfolio.api.rest.hero;

import com.portfolio.api.rest.hero.dto.HeroDTO;
import com.portfolio.api.rest.hero.entity.Hero;
import com.portfolio.api.rest.hero.service.HeroService;
import com.portfolio.api.utils.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hero")
@Tag(name = "Hero", description = "Endpoints for Hero Section")
@SecurityRequirement(name = "jwt-auth")
public class HeroController {
    private ObjectMapper objectMapper;
    public HeroService heroService;

    @Autowired
    public HeroController(ObjectMapper objectMapper, HeroService heroService) {
        this.objectMapper = objectMapper;
        this.heroService = heroService;
    }

    @PostMapping("")
    @Operation(summary = "Create a new hero")
    public ResponseEntity<ApiResponse<Object>> save(@Valid @RequestBody HeroDTO heroDTO) {
        Hero hero = heroService.save(heroDTO);
        return ResponseEntity.ok(new ApiResponse<>(200, "Hero created successfully", null));

    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Hero>>> findAll() {
        List<Hero> heroes = heroService.findAll();
        return ResponseEntity.ok(new ApiResponse<>(200, "Heroes found successfully", heroes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteById(@PathVariable int id) {
        heroService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Hero deleted successfully", null));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> update(@RequestBody Hero hero, @PathVariable int id) {
        Hero updatedHero = heroService.update(hero, id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Hero updated successfully", updatedHero));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Hero>> findById(@PathVariable int id) {
        Hero hero = heroService.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Hero found successfully", hero));
    }

}
