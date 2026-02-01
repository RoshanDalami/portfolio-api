package com.portfolio.api.rest.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {
    @NotBlank(message = "Email is required")
    @Schema(
            example = "john.doe@example.com"
    )
    private String email;

    @NotBlank(message = "Username is required")
    @Schema(
            example = "John doe"
    )
    private String username;

    @NotBlank(message = "Password is required")
    @Schema(example = "password")
    private String password;

    @Schema(example = "USER")
    private String role;

    public @NotBlank(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Username is required") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username is required") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Password is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
