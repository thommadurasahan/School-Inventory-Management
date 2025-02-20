package com.school.inventory.service;

import com.school.inventory.entity.Survey;
import com.school.inventory.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyService {
    private final SurveyRepository surveyRepository;

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Optional<Survey> getSurveyById(Short id) {
        return surveyRepository.findById(id);
    }

    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public Survey updateSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public void deleteSurvey(Short id) {
        surveyRepository.deleteById(id);
    }
}
