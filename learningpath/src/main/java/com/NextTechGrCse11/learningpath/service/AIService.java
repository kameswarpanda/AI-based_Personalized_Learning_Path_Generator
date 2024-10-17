package com.NextTechGrCse11.learningpath.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.NextTechGrCse11.learningpath.model.UserInput;

@Service
public class AIService {
	
	public String getLearningPath(UserInput userInput) {
        RestTemplate restTemplate = new RestTemplate();
        String flaskUrl = "http://localhost:5000/generate-learning-path";
        // Make a POST request to Flask with the user's input
        String learningPath = restTemplate.postForObject(flaskUrl, userInput, String.class);
        return learningPath;
    }

}
