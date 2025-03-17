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

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, Profile profileDetails) {
        return profileRepository.findById(id).map(profile -> {
            profile.setFirstName(profileDetails.getFirstName());
            profile.setLastName(profileDetails.getLastName());
            profile.setEmail(profileDetails.getEmail());
            profile.setPhone(profileDetails.getPhone());
            return profileRepository.save(profile);
        }).orElse(null);
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
