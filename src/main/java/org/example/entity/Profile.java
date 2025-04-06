package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Champs communs
    private String email;
    private String phone;
    private String profileType; // "CANDIDATE" ou "COMPANY"

    // Champs spécifiques pour les candidats
    private String firstName;
    private String lastName;
    private String skills;
    private Integer experience;

    // Champs spécifiques pour les entreprises
    private String companyName;
    private String industry;
    private String website;
    private String address;

    // Constructeur par défaut
    public Profile() {}

    // Constructeur complet
    public Profile(String email, String phone, String profileType, String firstName, String lastName, String skills, Integer experience, String companyName, String industry, String website, String address) {
        this.email = email;
        this.phone = phone;
        this.profileType = profileType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.experience = experience;
        this.companyName = companyName;
        this.industry = industry;
        this.website = website;
        this.address = address;
    }

    // Getters et Setters
    public Long getId() { return id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getProfileType() { return profileType; }
    public void setProfileType(String profileType) { this.profileType = profileType; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public Integer getExperience() { return experience; }
    public void setExperience(Integer experience) { this.experience = experience; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
