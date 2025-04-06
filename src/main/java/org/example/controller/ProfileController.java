package org.example.controller;

import org.example.entity.Profile;
import org.example.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Ajouter un profil
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile createdProfile = profileService.saveProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile);  // Retourne un 201 Created
    }

    // Récupérer tous les profils
    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return profiles.isEmpty()
                ? ResponseEntity.noContent().build()  // Retourne 204 si aucun profil n'est trouvé
                : ResponseEntity.ok(profiles);
    }

    // Récupérer un profil par ID
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Optional<Profile> profile = profileService.getProfileById(id);
        return profile.map(ResponseEntity::ok)  // Si le profil existe
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)  // Sinon renvoie 404
                        .body(new Profile()));
    }

    // Récupérer un profil par email
    @GetMapping("/email/{email}")
    public ResponseEntity<Profile> getProfileByEmail(@PathVariable String email) {
        Optional<Profile> profile = profileService.getProfileByEmail(email);
        return profile.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new Profile()));  // Profil non trouvé
    }

    // Récupérer tous les profils par type (CANDIDATE ou COMPANY)
    @GetMapping("/type/{profileType}")
    public ResponseEntity<List<Profile>> getProfilesByType(@PathVariable String profileType) {
        List<Profile> profiles = profileService.getProfilesByType(profileType);
        return profiles.isEmpty()
                ? ResponseEntity.noContent().build()  // Retourne 204 si aucun profil du type spécifié
                : ResponseEntity.ok(profiles);
    }

    // Mettre à jour un profil
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profileDetails) {
        Optional<Profile> existingProfile = profileService.getProfileById(id);

        if (existingProfile.isPresent()) {
            Profile updatedProfile = profileService.updateProfile(id, profileDetails);
            return ResponseEntity.ok(updatedProfile);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Retourne 404 si profil non trouvé
        }
    }

    // Supprimer un profil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        Optional<Profile> profile = profileService.getProfileById(id);

        if (profile.isPresent()) {
            profileService.deleteProfile(id);
            return ResponseEntity.noContent().build();  // 204 No Content pour suppression réussie
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Retourne 404 si profil non trouvé
        }
    }
}
