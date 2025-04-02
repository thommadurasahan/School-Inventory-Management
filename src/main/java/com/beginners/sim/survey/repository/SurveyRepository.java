package com.beginners.sim.survey.repository;

import com.beginners.sim.survey.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    @Query(value = "SELECT * FROM survey WHERE survey_on = :surveyOn", nativeQuery = true)
    List<Survey> findSurveysByDate(@Param("surveyOn") Date surveyOn);


}