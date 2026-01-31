package com.portfolio.api.rest.projects.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="Projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "live_link")
    private String liveLink;

    @ElementCollection
    @CollectionTable(
            name = "project_technologies",
            joinColumns = @JoinColumn(name = "project_id")
    )
    @Column(name = "technologies")
    private List<String> techUsed;

    @Column(name = "thumbnail")
    private String thumbnail;

    public Projects() {

    }

    public Projects(String title, String description, String githubLink, String liveLink, List<String> techUsed, String thumbnail) {
        this.title = title;
        this.description = description;
        this.githubLink = githubLink;
        this.liveLink = liveLink;
        this.techUsed = techUsed;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getLiveLink() {
        return liveLink;
    }

    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }

    public List<String> getTechUsed() {
        return techUsed;
    }

    public void setTechUsed(List<String> techUsed) {
        this.techUsed = techUsed;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
