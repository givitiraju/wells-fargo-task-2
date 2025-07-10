package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // e.g., "BUY" or "SELL"
    private LocalDate date;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "security_id")
    private Security security;

    public Transaction(String type, LocalDate date, int quantity, Security security) {
        this.type = type;
        this.date = date;
        this.quantity = quantity;
        this.security = security;
    }

    public Transaction() {}

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }
}

