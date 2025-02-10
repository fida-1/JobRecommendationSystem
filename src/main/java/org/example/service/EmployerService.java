package org.example.service;

import org.example.entity.Employer;
import org.example.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public Employer registerEmployer(Employer employer) {
        // Vérifier si l'email existe déjà
        if (employerRepository.findByEmail(employer.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        return employerRepository.save(employer);
    }

    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }
}
