package com.portfolio.api.rest.certificates.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "institution")
    private String institution;

    @Column(name = "certificate_url")
    private String certificateUrl;

    @Column(name = "title")
    private String title;

    @Column(name = "gainedDate")
    private String gainedDate;

    @ElementCollection
    @CollectionTable(
            name = "skilled_gained",
            joinColumns = @JoinColumn(name = "certificate_id")
    )
    @Column(name = "skill")
    private List<String> skills;

    public Certificate() {
    }

    public Certificate(String imageUrl, String institution, String certificateUrl, String title, List<String> skills) {
        this.imageUrl = imageUrl;
        this.institution = institution;
        this.certificateUrl = certificateUrl;
        this.title = title;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getGainedDate() {
        return gainedDate;
    }

    public void setGainedDate(String gainedDate) {
        this.gainedDate = gainedDate;
    }

    @Override
    public String toString() {
        return "Certificate [id=" + id + ", imageUrl=" + imageUrl + ", institution=" + institution + ", certificateUrl=" + certificateUrl + ", title=" + title + ", skills=" + skills + "]";
    }
}
