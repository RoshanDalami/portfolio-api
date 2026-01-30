package com.portfolio.api.rest.experience.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class ExperienceDTO {
    @Schema(
            example = "Softech Foundation Pvt. Ltd."
    )
    @NotBlank(message = "Company is mandatory")
    private String companyName;

    @Schema(
            example = "2023"
    )
    @NotBlank(message = "Start Date is Mandatory")
    private String start;

    @Schema(
            example = "Present"
    )
    @NotBlank(message = "End Date is Mandatory")
    private String end;

    @Schema(
            example = "Software Engineer"
    )
    @NotBlank(message = "Position is Mandatory")
    private String position;

    @Schema(
            example = "Working on the backend of the application"
    )
    @NotBlank(message = "Description is Mandatory")
    private String description;

    public @NotBlank(message = "Company is mandatory") String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@NotBlank(message = "Company is mandatory") String companyName) {
        this.companyName = companyName;
    }

    public @NotBlank(message = "Start Date is Mandatory") String getStart() {
        return start;
    }

    public void setStart(@NotBlank(message = "Start Date is Mandatory") String start) {
        this.start = start;
    }

    public @NotBlank(message = "End Date is Mandatory") String getEnd() {
        return end;
    }

    public void setEnd(@NotBlank(message = "End Date is Mandatory") String end) {
        this.end = end;
    }

    public @NotBlank(message = "Position is Mandatory") String getPosition() {
        return position;
    }

    public void setPosition(@NotBlank(message = "Position is Mandatory") String position) {
        this.position = position;
    }

    public @NotBlank(message = "Description is Mandatory") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is Mandatory") String description) {
        this.description = description;
    }
}
