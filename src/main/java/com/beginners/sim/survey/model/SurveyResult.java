package com.beginners.sim.survey.model;

import com.beginners.sim.inventory.model.Type;
import com.beginners.sim.order.model.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "survey_result")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyResult {
    // Todo
    //  Create package exception, include Notfound exception
    //  Create a class SurveyResultNotFoundException

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_result_id")
    private long surveyResultId;

    @Column(name = "survey_id")
    private Short surveyId;

    @Column(name = "type_id")
    private Short typeId;

    @Column(name = "order_id")
    private Short orderId;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "present_quantity")
    private Integer presentQuantity;

    @Column(name = "absent_quantity")
    private Integer absentQuantity;

    @Column(name = "ordered_quantity")
    private Integer orderedQuantity;

    @Column(name = "good_quantity")
    private Integer goodQuantity;

    @Column(name = "repair_quantity")
    private Integer repairQuantity;

    @Column(name = "sale_quantity")
    private Integer saleQuantity;

    @Column(name = "destroy_quantity")
    private Integer destroyQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", insertable = false, updatable = false)
    private Survey survey;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private Type type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;
}