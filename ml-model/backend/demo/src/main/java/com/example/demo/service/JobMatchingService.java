 package com.example.demo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobMatchingService {

    private final String ML_API_URL = "http://localhost:5000/match";

    public List<MatchingResult> match(String jobDesc, List<String> resumes) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> payload = new HashMap<>();
        payload.put("job", jobDesc);
        payload.put("resumes", resumes);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);

        ResponseEntity<MatchingResult[]> response = restTemplate.postForEntity(
                ML_API_URL,
                requestEntity,
                MatchingResult[].class
        );

        return Arrays.asList(response.getBody());
    }
}
