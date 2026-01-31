package com.portfolio.api.rest.certificates.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CertificateDTO {

    @NotBlank(message = "Certificate URL is required")
    private String certificateUrl;

    @NotBlank(message = "Institution is required")
    private String institution;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Certificate Gained date is required")
    private String gainedDate;

    @NotEmpty(message = "Skilled Gained")
    @Size(min = 1, message = "At least one skill is required")
    private List<@NotBlank(message = "Skill is required") String> skills;

    public @NotBlank(message = "Certificate URL is required") String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(@NotBlank(message = "Certificate URL is required") String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }

    public @NotBlank(message = "Institution is required") String getInstitution() {
        return institution;
    }

    public void setInstitution(@NotBlank(message = "Institution is required") String institution) {
        this.institution = institution;
    }

    public @NotBlank(message = "Title is required") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title is required") String title) {
        this.title = title;
    }

    public @NotBlank(message = "Certificate Gained date is required") String getGainedDate() {
        return gainedDate;
    }

    public void setGainedDate(@NotBlank(message = "Certificate Gained date is required") String gainedDate) {
        this.gainedDate = gainedDate;
    }

    public @NotEmpty(message = "Skilled Gained") @Size(min = 1, message = "At least one skill is required") List<@NotBlank(message = "Skill is required") String> getSkills() {
        return skills;
    }

    public void setSkills(@NotEmpty(message = "Skilled Gained") @Size(min = 1, message = "At least one skill is required") List<@NotBlank(message = "Skill is required") String> skills) {
        this.skills = skills;
    }
}
