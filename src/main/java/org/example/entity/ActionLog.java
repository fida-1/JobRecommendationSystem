package org.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "action_logs")
public class ActionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime actionDate;
    private String actionDescription;
    private String performedBy;

    // Constructeurs
    public ActionLog() {}

    public ActionLog(LocalDateTime actionDate, String actionDescription, String performedBy) {
        this.actionDate = actionDate;
        this.actionDescription = actionDescription;
        this.performedBy = performedBy;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }
}
