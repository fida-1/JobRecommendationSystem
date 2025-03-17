package org.example.controller;

import org.example.entity.JobOffer;
import org.example.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/joboffers")
public class JobOfferController {

    @Autowired
    private JobOfferService jobOfferService;

    @GetMapping
    public List<JobOffer> getAllJobOffers() {
        return jobOfferService.getAllJobOffers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobOffer> getJobOfferById(@PathVariable Long id) {
        Optional<JobOffer> jobOffer = jobOfferService.getJobOfferById(id);
        return jobOffer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public JobOffer createJobOffer(@RequestBody JobOffer jobOffer) {
        return jobOfferService.createJobOffer(jobOffer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobOffer> updateJobOffer(@PathVariable Long id, @RequestBody JobOffer jobOfferDetails) {
        JobOffer updated = jobOfferService.updateJobOffer(id, jobOfferDetails);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobOffer(@PathVariable Long id) {
        jobOfferService.deleteJobOffer(id);
        return ResponseEntity.noContent().build();
    }
}
