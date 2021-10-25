package com.example.tutorialapp.service;

import com.example.tutorialapp.model.Tutorial;
import com.example.tutorialapp.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;

    @Override
    public ResponseEntity<List<Tutorial>> getAllTutorials(String title) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();
            if (title == null) tutorialRepository.findAll().forEach(tutorials::add);
            else
                tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
            if (tutorials.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
