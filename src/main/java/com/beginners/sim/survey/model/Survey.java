package com.beginners.sim.survey.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "survey")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
    // Todo
    //  Create package exception, include Notfound exception
    //  Create a class SurveyNotFoundException

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private long surveyId;

    @Column(name = "survey_name")
    private String surveyName;

    @Column(name = "survey_on")
    @Temporal(TemporalType.DATE)
    private Date surveyOn;

    @OneToMany(mappedBy = "survey")
    private List<SurveyResult> surveyResults;
}