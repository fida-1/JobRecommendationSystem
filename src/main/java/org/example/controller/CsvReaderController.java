package org.example.controller;

import org.example.entity.CsvReader;
import org.example.service.CsvReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/csv")
public class CsvReaderController {

    @Autowired
    private CsvReaderService csvReaderService;

    // Endpoint pour télécharger un fichier CSV
    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            // Sauvegarder le fichier CSV sur le disque ou base de données
            File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFile);
            csvReaderService.storeCsvFile(tempFile);
            return ResponseEntity.status(HttpStatus.OK).body("CSV file uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file.");
        }
    }

    // Endpoint pour récupérer un fichier CSV
    @GetMapping("/{id}")
    public ResponseEntity<CsvReader> getCsvFile(@PathVariable Long id) {
        CsvReader csvReader = csvReaderService.getCsvFile(id);
        if (csvReader != null) {
            return ResponseEntity.ok(csvReader);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
