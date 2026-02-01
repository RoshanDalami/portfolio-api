package com.portfolio.api.rest.projects.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public class ProjectDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Github profile")
    private String githubLink;

    @NotBlank(message = "Live link")
    private String liveLink;

    @NotEmpty(message = "techUsed cannot be empty - provide at least one technology")
    @Size(max = 15, message = "Maximum 15 technologies allowed")
    private List<@NotBlank(message = "Each technology must not be blank") @Size(max = 50, message = "Technology name too long") String> techUsed;


    private String thumbnail;

    private MultipartFile thumbnailFile;

    public @NotBlank(message = "Title is required") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title is required") String title) {
        this.title = title;
    }

    public @NotBlank(message = "Description is required") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is required") String description) {
        this.description = description;
    }

    public @NotBlank(message = "Github profile") String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(@NotBlank(message = "Github profile") String githubLink) {
        this.githubLink = githubLink;
    }

    public @NotBlank(message = "Live link") String getLiveLink() {
        return liveLink;
    }

    public void setLiveLink(@NotBlank(message = "Live link") String liveLink) {
        this.liveLink = liveLink;
    }

    public @NotEmpty(message = "techUsed cannot be empty - provide at least one technology") @Size(max = 15, message = "Maximum 15 technologies allowed") List<@NotBlank(message = "Each technology must not be blank") @Size(max = 50, message = "Technology name too long") String> getTechUsed() {
        return techUsed;
    }

    public void setTechUsed(@NotEmpty(message = "techUsed cannot be empty - provide at least one technology") @Size(max = 15, message = "Maximum 15 technologies allowed") List<@NotBlank(message = "Each technology must not be blank") @Size(max = 50, message = "Technology name too long") String> techUsed) {
        this.techUsed = techUsed;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public MultipartFile getThumbnailFile() {
        return thumbnailFile;
    }

    public void setThumbnailFile(MultipartFile thumbnailFile) {
        this.thumbnailFile = thumbnailFile;
    }
}
