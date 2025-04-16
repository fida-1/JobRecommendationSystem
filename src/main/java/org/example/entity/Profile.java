package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "profiles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id")
})public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** "CANDIDATE" ou "COMPANY" */
    @Column(nullable = false)
    private String profileType;

    /** Optionnel pour COMPANY */
    @Column(nullable = true)
    private String firstName;

    /** Optionnel pour COMPANY */
    @Column(nullable = true)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    /** Optionnel pour COMPANY */
    @Column(nullable = true)
    private String skills;

    /** Optionnel pour COMPANY */
    @Column(nullable = true)
    private Integer experience;

    /** Optionnel pour CANDIDATE */
    @Column(nullable = true)
    private String companyName;

    /** Optionnel pour CANDIDATE */
    @Column(nullable = true)
    private String industry;

    /** Optionnel pour CANDIDATE */
    @Column(nullable = true)
    private String website;

    /** Optionnel pour CANDIDATE */
    @Column(nullable = true)
    private String address;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    public Profile() {}

    // --- Getters and Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
