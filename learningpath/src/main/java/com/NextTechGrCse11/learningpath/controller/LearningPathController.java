package com.NextTechGrCse11.learningpath.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NextTechGrCse11.learningpath.model.UserInput;
import com.NextTechGrCse11.learningpath.service.AIService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api")
public class LearningPathController {

	@Autowired
    private AIService aiService;

	@PostMapping("/generate-path")
    public ResponseEntity<?> generateLearningPath(@RequestBody UserInput userInput) {
        String learningPath = aiService.getLearningPath(userInput);
        return ResponseEntity.ok(Collections.singletonMap("path", learningPath));
    }
}
