package com.mobilebanking.models;

import com.mobilebanking.base.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "loans")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Loan extends BaseModel {

    @Column(name = "loan_id", nullable = false, unique = true)
    private String loanId;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "loan_type", nullable = false)
    private String loanType;

    @Column(name = "principal_amount", nullable = false)
    private double principalAmount;

    @Column(name = "interest_rate", nullable = false)
    private double interestRate;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    // Parameterized constructor
    public Loan(String loanId, String customerId, String loanType, double principalAmount, double interestRate, Date startDate, Date endDate) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.loanType = loanType;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
