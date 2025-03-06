package com.begginers.sim.survey.controller;

import com.begginers.sim.survey.model.Survey;
import com.begginers.sim.survey.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/survey")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyRepository surveyRepository;

    @PostMapping("/insertSurvey")
    public Survey insertSurvey(@RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }

    @GetMapping("/getAllSurveys")
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @GetMapping("/getSurvey/{id}")
    public Survey getSurveyById(@PathVariable Short id) {
        return surveyRepository.findById(id)
                .orElseThrow();
    }

    @PutMapping("/updateSurvey/{id}")
    public Survey updateSurvey(@PathVariable Short id, @RequestBody Survey updatedSurvey) {
        return surveyRepository.findById(id)
                .map(survey -> {
                    survey.setSurveyName(updatedSurvey.getSurveyName());
                    survey.setSurveyOn(updatedSurvey.getSurveyOn());
                    return surveyRepository.save(survey);
                })
                .orElseThrow();
    }

    @DeleteMapping("/deleteSurvey/{id}")
    public void deleteSurvey(@PathVariable Short id) {
        surveyRepository.deleteById(id);
    }
}