package com.ntstat.datatransfer;

import com.ntstat.entities.Account;

import java.util.Objects;

public class AccountDto {
    private int id;
    private String firstName;
    private String secondName;
    private String accountNumber;

    private AccountDto() {
    }

    private AccountDto(int id, String firstName, String secondName, String accountNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountNumber = accountNumber;
    }

    public static AccountDto fromDefault(int id, String firstName, String secondName, String accountNumber){
        return new AccountDto(id,firstName,secondName,accountNumber);
    }

    public static AccountDto fromEntity(Account account) {
        return new AccountDto(
                account.getId(),
                account.getFirstName(),
                account.getSecondName(),
                account.getAccountNumber()
        );
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(secondName, that.secondName) &&
                Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, secondName, accountNumber);
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
