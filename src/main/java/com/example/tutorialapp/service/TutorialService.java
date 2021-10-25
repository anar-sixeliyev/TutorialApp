package com.example.tutorialapp.service;

import com.example.tutorialapp.model.Tutorial;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TutorialService {
    ResponseEntity<List<Tutorial>> getAllTutorials(String title);

}