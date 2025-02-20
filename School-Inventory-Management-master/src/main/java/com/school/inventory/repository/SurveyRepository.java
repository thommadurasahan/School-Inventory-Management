package com.school.inventory.repository;

import com.school.inventory.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Short> {
    // Add custom query methods if needed
}
