package com.beginners.sim.survey.controller;

import com.beginners.sim.common.util.Constant;
import com.beginners.sim.survey.exception.SurveyNotFoundException;
import com.beginners.sim.survey.model.Survey;
import com.beginners.sim.survey.service.SurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(Constant.Survey_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping("/add-survey")
    public ResponseEntity<Survey> insertSurvey(@RequestBody Survey survey) {
        log.info("Inserting new survey: {}", survey);
        Survey savedSurvey = surveyService.saveSurvey(survey);
        return ResponseEntity.ok(savedSurvey);
    }

    @GetMapping("/view-surveys")
    public ResponseEntity<List<Survey>> getAllSurveys() {
        log.info("Getting all surveys");
        List<Survey> surveys = surveyService.getAllSurveys();
        if (surveys.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(surveys);
    }

    @GetMapping("/view-paginated-surveys")
    public ResponseEntity<Map<String, Object>> getAllSurveysWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        log.info("Getting paginated surveys with page: {} and size: {}", page, size);

        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ?
                Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        Page<Survey> pageSurveys = surveyService.findAll(pageable);
        List<Survey> surveys = pageSurveys.getContent();

        if (surveys.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("surveys", surveys);
        response.put("currentPage", pageSurveys.getNumber());
        response.put("totalItems", pageSurveys.getTotalElements());
        response.put("totalPages", pageSurveys.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/view-survey-by-id/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        log.info("Getting survey with ID: {}", id);
        try {
            Survey survey = surveyService.getSurveyById(id);
            return ResponseEntity.ok(survey);
        } catch (SurveyNotFoundException e) {
            log.error("Survey not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/view-surveys-by-date")
    public ResponseEntity<List<Survey>> getSurveysByDate(@RequestParam("date") Date createdDate) {
        log.info("Getting surveys by date: {}", createdDate);
        List<Survey> surveys = surveyService.findSurveysByDate(createdDate);

        if (surveys.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(surveys);
    }

    @PutMapping("/update-survey-by-id/{surveyId}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long surveyId, @RequestBody Survey updatedSurvey) {
        log.info("Updating survey with ID: {}", surveyId);
        try {
            Survey existingSurvey = surveyService.getSurveyById(surveyId);
            existingSurvey.setSurveyName(updatedSurvey.getSurveyName());
            // Update other fields as needed
            Survey savedSurvey = surveyService.saveSurvey(existingSurvey);
            return ResponseEntity.ok(savedSurvey);
        } catch (SurveyNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-survey-by-id/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        log.info("Deleting survey with ID: {}", id);
        try {
            surveyService.deleteSurvey(id);
            return ResponseEntity.noContent().build();
        } catch (SurveyNotFoundException e) {
            log.error("Survey not found with ID: {}", id);
            return ResponseEntity.noContent().build();
        }
    }
}