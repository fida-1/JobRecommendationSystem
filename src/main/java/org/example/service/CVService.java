package org.example.service;

import org.example.entity.CV;
import org.example.repository.CVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CVService {

    @Autowired
    private CVRepository cvRepository;

    public List<CV> getAllCVs() {
        return cvRepository.findAll();
    }

    public Optional<CV> getCVById(Long id) {
        return cvRepository.findById(id);
    }

    public CV createCV(CV cv) {
        return cvRepository.save(cv);
    }

    public void deleteCV(Long id) {
        cvRepository.deleteById(id);
    }
}
