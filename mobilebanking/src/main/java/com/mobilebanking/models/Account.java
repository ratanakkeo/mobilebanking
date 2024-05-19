package com.mobilebanking.models;

import com.mobilebanking.base.model.BaseModel;
import jakarta.persistence.*;

@Entity
public class Account extends BaseModel {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // getters and setters
}
