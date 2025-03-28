package com.beginners.sim.survey.service;

import com.beginners.sim.survey.exception.SurveyNotFoundException;
import com.beginners.sim.survey.model.Survey;
import com.beginners.sim.survey.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class SurvayServiceImpl implements SurvayService {
    
    private final SurveyRepository surveyRepository;

    @Override
    public Survey saveSurvey(Survey survey) {
        log.info("Saving survey: {}", survey);
        return surveyRepository.save(survey);
    }

    @Override
    public List<Survey> getAllSurveys() {
        log.info("Retrieving all surveys");
        return surveyRepository.findAll();
    }

    @Override
    public Survey getSurveyById(long id) throws SurveyNotFoundException {
        log.info("Retrieving survey with ID: {}", id);
        return surveyRepository.findById(id)
                .orElseThrow(() -> new SurveyNotFoundException("Survey not found with ID: " + id));
    }

    @Override
    public void deleteSurvey(long id) throws SurveyNotFoundException {
        log.info("Deleting survey with ID: {}", id);
        if (!surveyRepository.existsById(id)) {
            throw new SurveyNotFoundException("Survey not found with id: " + id);
        }
        surveyRepository.deleteById(id);
    }
    
    @Override
    public Page<Survey> findAll(Pageable pageable) {
        log.info("Retrieving paginated surveys with page: {}, size: {}", 
                pageable.getPageNumber(), pageable.getPageSize());
        return surveyRepository.findAll(pageable);
    }
    
    @Override
    public List<Survey> findSurveysByDate(Date createdDate) {
        log.info("Retrieving surveys by date: {}", createdDate);
        try {
            // Check if the repository has the method implemented
            if (hasMethod(surveyRepository.getClass(), "findSurveysByDate", Date.class)) {
                return surveyRepository.findSurveysByDate(createdDate);
            } else {
                log.warn("findSurveysByDate method not found in repository, returning empty list");
                return Collections.emptyList();
            }
        } catch (Exception e) {
            log.error("Error retrieving surveys by date: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
    
    // Helper method to check if a method exists
    private boolean hasMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
        try {
            clazz.getMethod(methodName, paramTypes);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}