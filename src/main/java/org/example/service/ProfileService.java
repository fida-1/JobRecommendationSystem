// src/main/java/org/example/service/ProfileService.java
package org.example.service;

import org.example.entity.Profile;
import org.example.exception.ProfileNotFoundException;
import org.example.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile saveProfile(Profile profile) {
        profileRepository.findByUserId(profile.getUser().getId()).ifPresent(existing -> {
            throw new IllegalStateException("Ce profil existe déjà pour cet utilisateur !");
        });
        return profileRepository.save(profile);
    }

    // Récupérer tous les profils
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    // Récupérer un profil par ID
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profil non trouvé avec id " + id));
    }

    // Récupérer un profil par email
    public Profile getProfileByEmail(String email) {
        return profileRepository.findByEmail(email)
                .orElseThrow(() -> new ProfileNotFoundException("Profil non trouvé avec email " + email));
    }
    public boolean profileExistsByUserId(Long userId) {
        return profileRepository.findByUserId(userId).isPresent();
    }

    // Récupérer un profil par userId
    public Profile getProfileByUserId(Long userId) {
        return profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ProfileNotFoundException("Profil non trouvé pour userId " + userId));
    }

    // Récupérer les profils par type
    public List<Profile> getProfilesByType(String profileType) {
        return profileRepository.findByProfileType(profileType);
    }

    // Mettre à jour un profil
    public Profile updateProfile(Long id, Profile details) {
        Profile p = getProfileById(id);
        p.setProfileType(details.getProfileType());
        p.setFirstName(details.getFirstName());
        p.setLastName(details.getLastName());
        p.setEmail(details.getEmail());
        p.setPhone(details.getPhone());
        p.setSkills(details.getSkills());
        p.setExperience(details.getExperience());
        p.setCompanyName(details.getCompanyName());
        p.setIndustry(details.getIndustry());
        p.setWebsite(details.getWebsite());
        p.setAddress(details.getAddress());
        p.setUser(details.getUser());
        return profileRepository.save(p);
    }

    // Supprimer un profil
    public void deleteProfile(Long id) {
        Profile p = getProfileById(id);
        profileRepository.delete(p);
    }
}
