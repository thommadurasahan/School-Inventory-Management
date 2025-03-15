package com.beginners.sim.survey.service;

import com.beginners.sim.survey.exception.SurveyResultNotFoundException;
import com.beginners.sim.survey.model.SurveyResult;
import com.beginners.sim.survey.repository.SurveyResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SurveyResultService {
    // TODO
    //  Change the class to interface, include only method signatures here
    //  Create a new class SurveyResultServiceImpl, implement it from the Service class and move all code to the Impl class

    private final SurveyResultRepository surveyResultRepository;

    public SurveyResult saveSurveyResult(SurveyResult surveyResult) {
        return surveyResultRepository.save(surveyResult);
    }

    public List<SurveyResult> getAllSurveyResults() {
        return surveyResultRepository.findAll();
    }

    public SurveyResult getSurveyResultById(long id) throws SurveyResultNotFoundException {
        return surveyResultRepository.findById(id)
                .orElseThrow(() -> new SurveyResultNotFoundException("Survey result not found with ID: " + id));
    }

    public List<SurveyResult> getSurveyResultsBySurveyId(long surveyId) {
        return surveyResultRepository.findBySurveyId(surveyId);
    }

    public void deleteSurveyResult(long id) throws SurveyResultNotFoundException {
        if (!surveyResultRepository.existsById(id)) {
            throw new SurveyResultNotFoundException("Survey result not found with id: " + id);
        }
        surveyResultRepository.deleteById(id);
    }

    public List<SurveyResult> getSurveyResultsByOrderId(long orderId) {
        return surveyResultRepository.findByOrderId(orderId);
    }

    public List<SurveyResult> getSurveyResultsByTypeId(long typeId) {
        return surveyResultRepository.findByTypeId(typeId);
    }
}
