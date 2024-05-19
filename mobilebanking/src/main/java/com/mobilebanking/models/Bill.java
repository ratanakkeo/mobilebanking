package com.mobilebanking.models;

import com.mobilebanking.base.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "bills")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bill extends BaseModel {

    @Column(name = "bill_number", nullable = false, unique = true)
    private String billNumber;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "due_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column(name = "paid_status", nullable = false)
    private boolean paidStatus;

    // Parameterized constructor
    public Bill(String billNumber, double amount, Date dueDate, boolean paidStatus) {
        this.billNumber = billNumber;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paidStatus = paidStatus;
    }
}
