package com.beginners.sim.survey.service;

import com.beginners.sim.survey.exception.SurveyNotFoundException;
import com.beginners.sim.survey.model.Survey;
import com.beginners.sim.survey.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SurvayService {
    // TODO
    //  Change the class to interface, include only method signatures here
    //  Create a new class SurveyServiceImpl, implement it from the Service class and move all code to the Impl class

    private final SurveyRepository surveyRepository;

    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Survey getSurveyById(long id) throws SurveyNotFoundException {
        return surveyRepository.findById(id)
                .orElseThrow(() -> new SurveyNotFoundException("Survey not found with ID: " + id));
    }

    public void deleteSurvey(long id) throws SurveyNotFoundException {
        if (!surveyRepository.existsById(id)) {
            throw new SurveyNotFoundException("Survey not found with id: " + id);
        }
        surveyRepository.deleteById(id);
    }
}
