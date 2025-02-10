package org.example.repository;

import org.example.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    // Méthode pour vérifier l'unicité de l'email
    Candidate findByEmail(String email);
}
