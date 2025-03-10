package com.begginers.sim.survey.controller;

import com.begginers.sim.survey.model.SurveyResult;
import com.begginers.sim.survey.repository.SurveyResultRepository;
import lombok.RequiredArgsConstructor;
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

    private final SurveyResultRepository surveyResultRepository;

    @PostMapping("/insertSurveyResult")
    public SurveyResult insertSurveyResult(@RequestBody SurveyResult surveyResult) {
        return surveyResultRepository.save(surveyResult);
    }

    @GetMapping("/getAllSurveyResults")
    public List<SurveyResult> getAllSurveyResults() {
        return surveyResultRepository.findAll();
    }

    @GetMapping("/getSurveyResult/{id}")
    public SurveyResult getSurveyResultById(@PathVariable Short id) {
        return surveyResultRepository.findById(id)
                .orElseThrow();
    }

    @GetMapping("/getBySurvey/{surveyId}")
    public List<SurveyResult> getSurveyResultsBySurveyId(@PathVariable Short surveyId) {
        return surveyResultRepository.findBySurveyId(surveyId);
    }

    @PutMapping("/updateSurveyResult/{id}")
    public SurveyResult updateSurveyResult(@PathVariable Short id, @RequestBody SurveyResult updatedResult) {
        return surveyResultRepository.findById(id)
                .map(result -> {
                    result.setTotalQuantity(updatedResult.getTotalQuantity());
                    result.setPresentQuantity(updatedResult.getPresentQuantity());
                    result.setAbsentQuantity(updatedResult.getAbsentQuantity());
                    result.setGoodQuantity(updatedResult.getGoodQuantity());
                    result.setRepairQuantity(updatedResult.getRepairQuantity());
                    result.setSaleQuantity(updatedResult.getSaleQuantity());
                    result.setDestroyQuantity(updatedResult.getDestroyQuantity());
                    return surveyResultRepository.save(result);
                })
                .orElseThrow();
    }

    @DeleteMapping("/deleteSurveyResult/{id}")
    public void deleteSurveyResult(@PathVariable Short id) {
        surveyResultRepository.deleteById(id);
    }
}