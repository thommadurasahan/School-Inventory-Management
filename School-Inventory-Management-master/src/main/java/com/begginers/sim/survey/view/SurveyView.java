package com.begginers.sim.survey.view;

import com.begginers.sim.survey.model.Survey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyView {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Survey> getAllSurveys() {
        return entityManager.createQuery("SELECT s FROM Survey s", Survey.class)
                .getResultList();
    }

    public Optional<Survey> getSurveyById(Short id) {
        Survey survey = entityManager.find(Survey.class, id);
        return Optional.ofNullable(survey);
    }

    public Survey createSurvey(Survey survey) {
        entityManager.persist(survey);
        return survey;
    }

    public Survey updateSurvey(Survey survey) {
        return entityManager.merge(survey);
    }

    public void deleteSurvey(Short id) {
        Survey survey = entityManager.find(Survey.class, id);
        if (survey != null) {
            entityManager.remove(survey);
        }
    }
}
