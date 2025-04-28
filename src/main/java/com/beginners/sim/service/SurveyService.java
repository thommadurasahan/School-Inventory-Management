package com.beginners.sim.service;

import com.beginners.sim.exception.SurveyNotFoundException;
import com.beginners.sim.model.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface SurveyService {
    Survey saveSurvey(Survey survey);

    List<Survey> getAllSurveys();

    Survey getSurveyById(long id) throws SurveyNotFoundException;

    void deleteSurvey(long id) throws SurveyNotFoundException;

    Page<Survey> findAll(Pageable pageable);

    List<Survey> findSurveysByDate(Date createdDate);
}
