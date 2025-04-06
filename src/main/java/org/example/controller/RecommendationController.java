package org.example.controller;

import org.example.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    /**
     * Endpoint POST /api/recommendations
     * Reçoit un profil utilisateur en JSON, le transmet au service de recommandation,
     * puis renvoie la liste des offres recommandées.
     *
     * @param profile map représentant l'objet Profile
     * @return map contenant "recommendations" : liste d'offres
     */
    @PostMapping
    public Map<String, Object> recommend(@RequestBody Map<String, Object> profile) {
        System.out.println("[RecommendationController] Profil reçu : " + profile);
        return recommendationService.getRecommendations(profile);
    }
}
