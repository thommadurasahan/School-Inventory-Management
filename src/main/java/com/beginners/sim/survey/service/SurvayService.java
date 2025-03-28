package com.beginners.sim.survey.service;

import com.beginners.sim.survey.exception.SurveyNotFoundException;
import com.beginners.sim.survey.model.Survey;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SurvayService {
    Survey saveSurvey(Survey survey);
    
    List<Survey> getAllSurveys();
    
    Survey getSurveyById(long id) throws SurveyNotFoundException;
    
    void deleteSurvey(long id) throws SurveyNotFoundException;

    Page<Survey> findAll(Pageable pageable);

    List<Survey> findSurveysByDate(Date createdDate);
}
