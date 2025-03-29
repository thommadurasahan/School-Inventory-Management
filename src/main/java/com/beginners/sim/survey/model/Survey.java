package com.beginners.sim.survey.model;

import com.beginners.sim.inventory.model.Type;
import com.beginners.sim.order.model.Order;
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
    private long surveyId;

    @Column(name = "survey_name")
    private String surveyName;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "present_quantity")
    private Integer presentQuantity;

    @Column(name = "order_id")
    private Short orderId;

    @Column(name = "ordered_quantity")
    private Integer orderedQuantity;

    @Column(name = "good_quantity")
    private Integer goodQuantity;

    @Column(name = "repair_quantity")
    private Integer repairQuantity;

    @Column(name = "survey_on")
    @Temporal(TemporalType.DATE)
    private Date surveyOn;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private Type type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

}