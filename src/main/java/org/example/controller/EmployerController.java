package org.example.controller;

import org.example.entity.Employer;
import org.example.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    // Enregistrement d'un employeur
    @PostMapping("/register")
    public ResponseEntity<Employer> registerEmployer(@RequestBody Employer employer) {
        Employer savedEmployer = employerService.registerEmployer(employer);
        return ResponseEntity.ok(savedEmployer);
    }

    // Récupération de tous les employeurs
    @GetMapping
    public ResponseEntity<List<Employer>> getAllEmployers() {
        List<Employer> employers = employerService.getAllEmployers();
        return ResponseEntity.ok(employers);
    }
}
