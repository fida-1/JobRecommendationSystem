package org.example.service;

import org.example.entity.CsvReader;
import org.example.repository.CsvReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CsvReaderService {

    @Autowired
    private CsvReaderRepository csvReaderRepository;

    public CsvReader storeCsvFile(File file) throws IOException {
        String fileName = file.getName();
        String fileType = Files.probeContentType(file.toPath());
        byte[] data = Files.readAllBytes(file.toPath());

        CsvReader csvReader = new CsvReader(fileName, fileType, data);

        // Sauvegarde dans la base de données
        return csvReaderRepository.save(csvReader);
    }

    // Méthode pour récupérer un fichier CSV par ID
    public CsvReader getCsvFile(Long id) {
        return csvReaderRepository.findById(id).orElse(null);
    }
}
