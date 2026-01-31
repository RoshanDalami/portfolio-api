package com.portfolio.api.rest.technical_toolkit.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Technical_Toolkit")
public class TechnicalToolkit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "value")
    private String value;

    public TechnicalToolkit() {
    }

    public TechnicalToolkit(String category, String value) {
        this.category = category;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TechnicalToolkit{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
