package com.portfolio.api.rest.technical_toolkit.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class TechnicalToolkitDTO {
    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Value is required")
    private String value;

    public @NotBlank(message = "Category is required") String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank(message = "Category is required") String category) {
        this.category = category;
    }

    public @NotBlank(message = "Value is required") String getValue() {
        return value;
    }

    public void setValue(@NotBlank(message = "Value is required") String value) {
        this.value = value;
    }
}
