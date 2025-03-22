package com.beginners.sim.survey.repository;

import com.beginners.sim.survey.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    // ToDo
//  Crete a custom method, custom query
}