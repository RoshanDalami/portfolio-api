package com.portfolio.api.rest.experience.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;



    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String endDate;

    @Column(name = "position")
    private String position;

    @Column(name = "description")
    private String description;

    public Experience() {
    }


    public Experience(String companyName, String start, String end, String position, String description) {
        this.companyName = companyName;
        this.startDate = start;
        this.endDate = end;
        this.position = position;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStart() {
        return startDate;
    }

    public void setStart(String start) {
        this.startDate = start;
    }

    public String getEnd() {
        return endDate;
    }

    public void setEnd(String end) {
        this.endDate = end;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "companyName='" + companyName + '\'' +
                ", start='" + startDate + '\'' +
                ", end='" + endDate + '\'' +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
