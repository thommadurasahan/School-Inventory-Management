package com.beginners.sim.survey.controller;

import com.beginners.sim.survey.exception.SurveyNotFoundException;
import com.beginners.sim.survey.model.Survey;
import com.beginners.sim.survey.service.SurvayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/survey")
@RequiredArgsConstructor
public class SurveyController {
    // Todo
    //  Create util package, class Constant, hardcode values
    //  Crete base url, create a method with pagination for getAll

    private final SurvayService surveyService;

    @PostMapping("/insertSurvey")
    public ResponseEntity<Survey> insertSurvey(@RequestBody Survey survey) {
        Survey savedSurvey = surveyService.saveSurvey(survey);
        return ResponseEntity.ok(savedSurvey);
    }

    @GetMapping("/getAllSurveys")
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = surveyService.getAllSurveys();
        return ResponseEntity.ok(surveys);
    }

    @GetMapping("/getSurvey/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Short id) {
        try {
            Survey survey = surveyService.getSurveyById(id);
            return ResponseEntity.ok(survey);
        } catch (SurveyNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateSurvey/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Short id, @RequestBody Survey updatedSurvey) {
        try {
            Survey existingSurvey = surveyService.getSurveyById(id);
            existingSurvey.setSurveyName(updatedSurvey.getSurveyName());
            existingSurvey.setSurveyOn(updatedSurvey.getSurveyOn());
            Survey savedSurvey = surveyService.saveSurvey(existingSurvey);
            return ResponseEntity.ok(savedSurvey);
        } catch (SurveyNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteSurvey/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Short id) {
        try {
            surveyService.deleteSurvey(id);
            return ResponseEntity.ok().build();
        } catch (SurveyNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}