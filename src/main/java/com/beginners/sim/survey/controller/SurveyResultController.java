package com.beginners.sim.survey.controller;

import com.beginners.sim.survey.exception.SurveyResultNotFoundException;
import com.beginners.sim.survey.model.SurveyResult;
import com.beginners.sim.survey.service.SurveyResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/surveyResult")
@RequiredArgsConstructor
public class SurveyResultController {
    // Todo
    //  Create util package, class Constant, hardcode values
    //  Crete base url, create a method with pagination for getAll

    private final SurveyResultService surveyResultService;

    @PostMapping("/insertSurveyResult")
    public ResponseEntity<SurveyResult> insertSurveyResult(@RequestBody SurveyResult surveyResult) {
        SurveyResult savedResult = surveyResultService.saveSurveyResult(surveyResult);
        return ResponseEntity.ok(savedResult);
    }

    @GetMapping("/getAllSurveyResults")
    public ResponseEntity<List<SurveyResult>> getAllSurveyResults() {
        List<SurveyResult> results = surveyResultService.getAllSurveyResults();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/getSurveyResult/{id}")
    public ResponseEntity<SurveyResult> getSurveyResultById(@PathVariable Short id) {
        try {
            SurveyResult result = surveyResultService.getSurveyResultById(id);
            return ResponseEntity.ok(result);
        } catch (SurveyResultNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getBySurvey/{surveyId}")
    public ResponseEntity<List<SurveyResult>> getSurveyResultsBySurveyId(@PathVariable Short surveyId) {
        List<SurveyResult> results = surveyResultService.getSurveyResultsBySurveyId(surveyId);
        return ResponseEntity.ok(results);
    }

    @PutMapping("/updateSurveyResult/{id}")
    public ResponseEntity<SurveyResult> updateSurveyResult(@PathVariable Short id, @RequestBody SurveyResult updatedResult) {
        try {
            SurveyResult existingResult = surveyResultService.getSurveyResultById(id);
            existingResult.setTotalQuantity(updatedResult.getTotalQuantity());
            existingResult.setPresentQuantity(updatedResult.getPresentQuantity());
            existingResult.setAbsentQuantity(updatedResult.getAbsentQuantity());
            existingResult.setGoodQuantity(updatedResult.getGoodQuantity());
            existingResult.setRepairQuantity(updatedResult.getRepairQuantity());
            existingResult.setSaleQuantity(updatedResult.getSaleQuantity());
            existingResult.setDestroyQuantity(updatedResult.getDestroyQuantity());

            SurveyResult savedResult = surveyResultService.saveSurveyResult(existingResult);
            return ResponseEntity.ok(savedResult);
        } catch (SurveyResultNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteSurveyResult/{id}")
    public ResponseEntity<Void> deleteSurveyResult(@PathVariable Short id) {
        try {
            surveyResultService.deleteSurveyResult(id);
            return ResponseEntity.ok().build();
        } catch (SurveyResultNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}