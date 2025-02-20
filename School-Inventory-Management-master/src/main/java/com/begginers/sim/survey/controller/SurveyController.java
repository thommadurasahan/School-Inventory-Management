package com.begginers.sim.survey.controller;

import com.begginers.sim.survey.model.Survey;
import com.begginers.sim.survey.view.SurveyView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SurveyController {
    private final SurveyView surveyView;

    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        return ResponseEntity.ok(surveyView.getAllSurveys());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Short id) {
        return surveyView.getSurveyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        return ResponseEntity.ok(surveyView.createSurvey(survey));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Short id, @RequestBody Survey survey) {
        survey.setSurveyId(id);
        return ResponseEntity.ok(surveyView.updateSurvey(survey));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Short id) {
        surveyView.deleteSurvey(id);
        return ResponseEntity.noContent().build();
    }
}
