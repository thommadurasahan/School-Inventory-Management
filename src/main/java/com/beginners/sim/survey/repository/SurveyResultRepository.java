package com.beginners.sim.survey.repository;

import com.beginners.sim.survey.model.SurveyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyResultRepository extends JpaRepository<SurveyResult, Long> {
    // ToDo
    //  Crete a custom method, custom query

    // Custom method to find survey results by surveyId
    List<SurveyResult> findBySurveyId(Long surveyId);

    List<SurveyResult> findByTypeId(long typeId);

    List<SurveyResult> findByOrderId(long orderId);
}
