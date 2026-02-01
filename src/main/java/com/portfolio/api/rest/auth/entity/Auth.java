package com.portfolio.api.rest.auth.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Users")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "userId")
    private UUID userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role", columnDefinition = "varchar(20)", nullable = false)
    private String role;

    @Column(name = "email", columnDefinition = "varchar(50)", unique = true)
    private String email;

    public Auth(){

    }

    public Auth(String username, String password, String role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Auth [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
                + ", email=" + email + "]";
    }
}
