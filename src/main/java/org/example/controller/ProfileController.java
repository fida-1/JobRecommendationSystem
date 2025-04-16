// src/main/java/org/example/controller/ProfileController.java
package org.example.controller;

import org.example.entity.Profile;
import org.example.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/exists/{userId}")
    public ResponseEntity<Boolean> profileExists(@PathVariable Long userId) {
        return ResponseEntity.ok(profileService.profileExistsByUserId(userId));
    }

    // POST   /api/profiles
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile created = profileService.saveProfile(profile);
        return ResponseEntity.status(201).body(created);
    }

    // GET    /api/profiles
    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> list = profileService.getAllProfiles();
        return ResponseEntity.ok(list);
    }

    // GET    /api/profiles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getById(@PathVariable Long id) {
        Profile p = profileService.getProfileById(id);
        return ResponseEntity.ok(p);
    }

    // GET    /api/profiles/email/{email}
    @GetMapping("/email/{email:.+}")
    public ResponseEntity<Profile> getByEmail(@PathVariable String email) {
        Profile p = profileService.getProfileByEmail(email);
        return ResponseEntity.ok(p);
    }

    // GET    /api/profiles/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<Profile> getByUserId(@PathVariable Long userId) {
        Profile p = profileService.getProfileByUserId(userId);
        return ResponseEntity.ok(p);
    }

    // GET    /api/profiles/type/{profileType}
    @GetMapping("/type/{profileType}")
    public ResponseEntity<List<Profile>> getByType(@PathVariable String profileType) {
        List<Profile> list = profileService.getProfilesByType(profileType);
        return ResponseEntity.ok(list);
    }

    // PUT    /api/profiles/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Profile> update(@PathVariable Long id, @RequestBody Profile details) {
        Profile updated = profileService.updateProfile(id, details);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/profiles/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
