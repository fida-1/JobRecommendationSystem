package org.example.service;

import org.example.entity.Application;
import org.example.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    public Application updateApplication(Long id, Application appDetails) {
        return applicationRepository.findById(id).map(app -> {
            app.setCandidate(appDetails.getCandidate());
            app.setJobOffer(appDetails.getJobOffer());
            app.setCv(appDetails.getCv());
            app.setCoverLetter(appDetails.getCoverLetter());
            app.setSubmissionDate(appDetails.getSubmissionDate());
            app.setStatus(appDetails.getStatus());
            return applicationRepository.save(app);
        }).orElse(null);
    }

    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}
