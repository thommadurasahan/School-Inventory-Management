package com.begginers.sim.survey.repository;

import com.begginers.sim.survey.model.SurveyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyResultRepository extends JpaRepository<SurveyResult, Short> {
    // ToDo
    //  Crete a custom method, custom query

    // Custom method to find survey results by surveyId
    List<SurveyResult> findBySurveyId(Short surveyId);
}
