package com.example.tutorialapp.service;

import com.example.tutorialapp.model.Tutorial;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface TutorialService {
    ResponseEntity<List<Tutorial>> getAllTutorials(String title);

    ResponseEntity<Tutorial> getTutorialById(long id);

    ResponseEntity<Tutorial> createTutorial(Tutorial tutorial);

    ResponseEntity<Tutorial> updateTutorial(long id, Tutorial tutorial);

    ResponseEntity<HttpStatus> deleteTutorial(long id);

    ResponseEntity<HttpStatus> deleteAllTutorials();

    ResponseEntity<List<Tutorial>> findByPublished();
}