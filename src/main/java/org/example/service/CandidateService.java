package org.example.service;

import org.example.entity.Candidate;
import org.example.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate registerCandidate(Candidate candidate) {
        // Vérifier si l'email existe déjà
        if (candidateRepository.findByEmail(candidate.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
}
