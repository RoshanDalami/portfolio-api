package com.portfolio.api.rest.hero.entity;

import jakarta.persistence.*;

@Entity()
@Table(name = "Hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstText")
    private String firstText;

    @Column(name = "subtext")
    private String subtext;

    @Column(name = "followingText")
    private String followingText;

    @Column(name = "endingText")
    private String endingText;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "email")
    private String email;

    public Hero() {
    }

    public Hero(String firstText, String subtext, String followingText, String endingText, String description, String location, String email) {
        this.firstText = firstText;
        this.subtext = subtext;
        this.followingText = followingText;
        this.endingText = endingText;
        this.description = description;
        this.location = location;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstText() {
        return firstText;
    }

    public void setFirstText(String firstText) {
        this.firstText = firstText;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public String getFollowingText() {
        return followingText;
    }

    public void setFollowingText(String followingText) {
        this.followingText = followingText;
    }

    public String getEndingText() {
        return endingText;
    }

    public void setEndingText(String endingText) {
        this.endingText = endingText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "hero{" +
                "firstText='" + firstText + '\'' +
                ", subtext='" + subtext + '\'' +
                ", followingText='" + followingText + '\'' +
                ", endingText='" + endingText + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
