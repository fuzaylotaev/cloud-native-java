package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private String number;

    public Account(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
