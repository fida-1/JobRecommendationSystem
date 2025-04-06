package org.example.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RecommendationService {

    private static final String PYTHON_SERVICE_URL = "http://localhost:5000/recommend";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Envoie le profil utilisateur au service Python et récupère les recommandations.
     *
     * @param profile données du profil (map clés/valeurs)
     * @return map contenant la clé "recommendations" et la liste des offres
     */
    public Map<String, Object> getRecommendations(Map<String, Object> profile) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Construire le payload
        Map<String, Object> payload = Map.of("profile", profile);
        System.out.println("[RecommendationService] Envoi du profil au service Python : " + payload);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(
                    PYTHON_SERVICE_URL,
                    request,
                    Map.class
            );
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody();
            } else {
                throw new IllegalStateException("Réponse inattendue du service Python : " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            throw new RuntimeException("Erreur lors de l'appel au service Python de recommandations", e);
        }
    }
}
