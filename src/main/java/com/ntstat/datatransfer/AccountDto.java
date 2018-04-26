package com.ntstat.datatransfer;

public class AccountDto {
    private int id;
    private String firstName;
    private String secondName;
    private int accountNumber;


    public AccountDto(int id, String firstName, String secondName, int accountNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountNumber = accountNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
