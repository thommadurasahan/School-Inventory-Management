package com.beginners.sim.survey.model;

import com.beginners.sim.inventory.model.Type;
import com.beginners.sim.order.model.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "survey")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private long surveyId;

    @Column(name = "survey_name")
    private String surveyName;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "present_quantity")
    private Integer presentQuantity;

    @Column(name = "ordered_quantity")
    private Integer orderedQuantity;

    @Column(name = "good_quantity")
    private Integer goodQuantity;

    @Column(name = "repair_quantity")
    private Integer repairQuantity;

    @Column(name = "survey_on")
    @Temporal(TemporalType.DATE)
    private Date surveyOn;

    // Survey (1) - Type (1) Relationship (Owner Side)
    @OneToOne
    @JoinColumn(name = "type_id")
    private Type type;

    // Survey (1) - Order (1) Relationship (Owner Side)
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}