package com.school.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "survey")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Short surveyId;

    @Column(name = "survey_name")
    private String surveyName;

    @Column(name = "type_id")
    private Short typeId;

    @Column(name = "quantity")
    private Short quantity;

    @Column(name = "status_id")
    private Byte statusId;

    @Column(name = "label_id")
    private String labelId;

    @Column(name = "survey_date")
    @Temporal(TemporalType.DATE)
    private Date surveyDate;

    @Column(name = "conducted_by")
    private String conductedBy;

    @Column(name = "officer_from")
    private String officerFrom;

    @ManyToOne
    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    private Status status;
}
