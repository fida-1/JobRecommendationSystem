package org.example.controller;

import org.example.entity.Candidate;
import org.example.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin(origins = "*")  // Permet d'autoriser les requêtes depuis n'importe quel client (ex: Postman, front-end)
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    // Enregistrement d'un candidat (URL correcte pour le POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Retourne 201 Created en cas de succès
    public ResponseEntity<Candidate> registerCandidate(@RequestBody Candidate candidate) {
        Candidate savedCandidate = candidateService.registerCandidate(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCandidate);
    }

    // Récupération de tous les candidats
    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        return ResponseEntity.ok(candidates);
    }
}
