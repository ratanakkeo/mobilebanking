package com.mobilebanking.models;

import jakarta.persistence.*;

@Entity
public class Account extends BaseEntity{

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // getters and setters
}
