package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_offers")
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String requiredSkills;
    private String location;
    private double salary;
    private LocalDate publicationDate;
    private boolean isActive;

    // Constructeurs
    public JobOffer() {}

    public JobOffer(String title, String description, String requiredSkills,
                    String location, double salary, LocalDate publicationDate, boolean isActive) {
        this.title = title;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.location = location;
        this.salary = salary;
        this.publicationDate = publicationDate;
        this.isActive = isActive;
    }

    // Getters et Setters
    public Long getId() {
        return id;
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

    public String getRequiredSkills() {
        return requiredSkills;
    }
    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
}
