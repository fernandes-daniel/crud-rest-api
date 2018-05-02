package com.ntstat.entities;

import com.ntstat.datatransfer.AccountDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
    private int id;
    private String firstName;
    private String secondName;
    private String accountNumber;


    private Account(){}

    private Account(String firstName, String secondName, String accountNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountNumber = accountNumber;
    }

    public static Account fromDefault(String firstName, String secondName, String accountNumber) {
        return new Account(firstName,secondName,accountNumber);
    }

    public static Account fromDto(AccountDto accountDto) {
        return new Account(
                accountDto.getFirstName(),
                accountDto.getSecondName(),
                accountDto.getAccountNumber()
        );
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "SECOND_NAME")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Column(name = "ACCOUNT_NUMBER")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(firstName, account.firstName) &&
                Objects.equals(secondName, account.secondName) &&
                Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, accountNumber);
    }
}
