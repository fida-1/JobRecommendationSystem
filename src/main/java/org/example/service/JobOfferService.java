package org.example.service;

import org.example.entity.JobOffer;
import org.example.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    public List<JobOffer> getAllJobOffers() {
        return jobOfferRepository.findAll();
    }

    public Optional<JobOffer> getJobOfferById(Long id) {
        return jobOfferRepository.findById(id);
    }

    public JobOffer createJobOffer(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    public JobOffer updateJobOffer(Long id, JobOffer jobOfferDetails) {
        return jobOfferRepository.findById(id).map(offer -> {
            offer.setTitle(jobOfferDetails.getTitle());
            offer.setDescription(jobOfferDetails.getDescription());
            offer.setRequiredSkills(jobOfferDetails.getRequiredSkills());
            offer.setLocation(jobOfferDetails.getLocation());
            offer.setSalary(jobOfferDetails.getSalary());
            offer.setPublicationDate(jobOfferDetails.getPublicationDate());
            offer.setActive(jobOfferDetails.isActive());
            return jobOfferRepository.save(offer);
        }).orElse(null);
    }

    public void deleteJobOffer(Long id) {
        jobOfferRepository.deleteById(id);
    }
}
