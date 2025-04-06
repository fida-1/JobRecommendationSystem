package org.example.service;

import org.example.entity.Profile;
import org.example.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    // Créer un profil
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    // Récupérer tous les profils
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    // Récupérer un profil par ID
    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    // Récupérer un profil par email
    public Optional<Profile> getProfileByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    // Récupérer tous les profils par type
    public List<Profile> getProfilesByType(String profileType) {
        return profileRepository.findByProfileType(profileType);
    }

    // Mettre à jour un profil
    public Profile updateProfile(Long id, Profile profileDetails) {
        return profileRepository.findById(id).map(profile -> {
            profile.setEmail(profileDetails.getEmail());
            profile.setPhone(profileDetails.getPhone());
            profile.setProfileType(profileDetails.getProfileType());
            profile.setFirstName(profileDetails.getFirstName());
            profile.setLastName(profileDetails.getLastName());
            profile.setSkills(profileDetails.getSkills());
            profile.setExperience(profileDetails.getExperience());
            profile.setCompanyName(profileDetails.getCompanyName());
            profile.setIndustry(profileDetails.getIndustry());
            profile.setWebsite(profileDetails.getWebsite());
            profile.setAddress(profileDetails.getAddress());
            return profileRepository.save(profile);
        }).orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    // Supprimer un profil
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
