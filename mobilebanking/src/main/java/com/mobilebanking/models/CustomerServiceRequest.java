package com.mobilebanking.models;

import com.mobilebanking.base.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "customer_service_requests")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerServiceRequest extends BaseModel {

    @Column(name = "request_id", nullable = false, unique = true)
    private String requestId;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "request_type", nullable = false)
    private String requestType;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "solve_status", nullable = false)
    private String solveStatus;

    // Parameterized constructor
    public CustomerServiceRequest(String requestId, String customerId, String requestType, String description, String solveStatus) {
        this.requestId = requestId;
        this.customerId = customerId;
        this.requestType = requestType;
        this.description = description;
        this.solveStatus = solveStatus;
    }
}
