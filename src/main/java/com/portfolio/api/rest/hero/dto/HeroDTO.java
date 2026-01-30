package com.portfolio.api.rest.hero.dto;


import jakarta.validation.constraints.NotBlank;

public class HeroDTO {
    @NotBlank(message = "First Text is mandatory")
    private String firstText;

    @NotBlank(message = "Subtext is required")
    private String subtext;

    @NotBlank(message = "following text is required")
    private String followingText;

    @NotBlank(message = "Ending Text is requied")
    private String endingText;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Email is required")
    private String email;

    public @NotBlank(message = "First Text is mandatory") String getFirstText() {
        return firstText;
    }

    public void setFirstText(@NotBlank(message = "First Text is mandatory") String firstText) {
        this.firstText = firstText;
    }

    public @NotBlank(message = "Subtext is required") String getSubtext() {
        return subtext;
    }

    public void setSubtext(@NotBlank(message = "Subtext is required") String subtext) {
        this.subtext = subtext;
    }

    public @NotBlank(message = "following text is required") String getFollowingText() {
        return followingText;
    }

    public void setFollowingText(@NotBlank(message = "following text is required") String followingText) {
        this.followingText = followingText;
    }

    public @NotBlank(message = "Ending Text is requied") String getEndingText() {
        return endingText;
    }

    public void setEndingText(@NotBlank(message = "Ending Text is requied") String endingText) {
        this.endingText = endingText;
    }

    public @NotBlank(message = "Description is required") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is required") String description) {
        this.description = description;
    }

    public @NotBlank(message = "Location is required") String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank(message = "Location is required") String location) {
        this.location = location;
    }

    public @NotBlank(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") String email) {
        this.email = email;
    }
}
