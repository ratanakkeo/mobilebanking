package com.mobilebanking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        modifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new Date();
    }
}
