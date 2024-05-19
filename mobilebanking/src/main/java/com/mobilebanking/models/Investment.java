package com.mobilebanking.models;

import com.mobilebanking.base.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "investments")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Investment extends BaseModel {

    @Column(name = "investment_id", nullable = false, unique = true)
    private String investmentId;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "investment_type", nullable = false)
    private String investmentType;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    // Parameterized constructor
    public Investment(String investmentId, String customerId, String investmentType, double amount, Date startDate, Date endDate) {
        this.investmentId = investmentId;
        this.customerId = customerId;
        this.investmentType = investmentType;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
