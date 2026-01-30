package com.portfolio.api.rest.projects.dto;

import jakarta.validation.constraints.NotBlank;

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

    @NotBlank(message = "Technologies used")
    private List<String> techUsed;

    private String thumbnail;

    private File thumbnailFile;

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

    public @NotBlank(message = "Technologies used") List<String> getTechUsed() {
        return techUsed;
    }

    public void setTechUsed(@NotBlank(message = "Technologies used") List<String> techUsed) {
        this.techUsed = techUsed;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public File getThumbnailFile() {
        return thumbnailFile;
    }

    public void setThumbnailFile(File thumbnailFile) {
        this.thumbnailFile = thumbnailFile;
    }
}
