package com.ntstat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "ACCOUNTS" )
public class Account {
    private int id;
    private String firstName;
    private String secondName;
    private int accountNumber;


    public Account(int id, String firstName, String secondName, int accountNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountNumber = accountNumber;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int getId() {
        return id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "SECOND_NAME")
    public String getSecondName() {
        return secondName;
    }

    @Column(name = "ACCOUNT_NUMBER")
    public int getAccountNumber() {
        return accountNumber;
    }

}
