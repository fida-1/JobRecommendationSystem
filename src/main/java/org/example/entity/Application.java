package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Association avec Candidate
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    // Association avec JobOffer
    @ManyToOne
    @JoinColumn(name = "job_offer_id")
    private JobOffer jobOffer;

    // Association avec CV (optionnel, si tu gères les CV séparément)
    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;

    private String coverLetter;
    private LocalDate submissionDate;
    private String status;  // ex: "pending", "accepted", "rejected"

    // Constructeurs
    public Application() {}

    public Application(Candidate candidate, JobOffer jobOffer, CV cv, String coverLetter,
                       LocalDate submissionDate, String status) {
        this.candidate = candidate;
        this.jobOffer = jobOffer;
        this.cv = cv;
        this.coverLetter = coverLetter;
        this.submissionDate = submissionDate;
        this.status = status;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public Candidate getCandidate() {
        return candidate;
    }
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }
    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }

    public CV getCv() {
        return cv;
    }
    public void setCv(CV cv) {
        this.cv = cv;
    }

    public String getCoverLetter() {
        return coverLetter;
    }
    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }
    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
