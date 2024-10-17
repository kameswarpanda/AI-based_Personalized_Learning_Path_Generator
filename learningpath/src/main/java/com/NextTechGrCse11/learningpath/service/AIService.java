package com.NextTechGrCse11.learningpath.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.NextTechGrCse11.learningpath.model.UserInput;

@Service
public class AIService {
	
	private static final String AI_MODEL_URL = "http://localhost:5000/generate-learning-path";

    public String getLearningPath(UserInput userInput) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(AI_MODEL_URL, userInput, String.class);
    }

}
