package org.example.controller;

import org.example.entity.CV;
import org.example.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cvs")
public class CVController {

    @Autowired
    private CVService cvService;

    @GetMapping
    public List<CV> getAllCVs() {
        return cvService.getAllCVs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CV> getCVById(@PathVariable Long id) {
        Optional<CV> cv = cvService.getCVById(id);
        return cv.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CV createCV(@RequestBody CV cv) {
        return cvService.createCV(cv);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCV(@PathVariable Long id) {
        cvService.deleteCV(id);
        return ResponseEntity.noContent().build();
    }
}
