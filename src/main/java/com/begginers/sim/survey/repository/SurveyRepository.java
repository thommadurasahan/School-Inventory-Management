package com.begginers.sim.survey.repository;

import com.begginers.sim.survey.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Short> {
    // ToDo
//  Crete a custom method, custom query
}