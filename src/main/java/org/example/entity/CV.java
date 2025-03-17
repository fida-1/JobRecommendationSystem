package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "cvs")
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    // Constructeurs
    public CV() {}

    public CV(String fileName, String fileType, byte[] data, Profile profile) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.profile = profile;
    }

    // Getters et Setters
    public Long getId() { return id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public byte[] getData() { return data; }
    public void setData(byte[] data) { this.data = data; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }
}
