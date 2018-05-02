package com.ntstat.exceptions;

public class AccountWithIdNotFoundException extends RuntimeException {
    private int id;

    public AccountWithIdNotFoundException(int id) {
        this.id = id;
    }
}
