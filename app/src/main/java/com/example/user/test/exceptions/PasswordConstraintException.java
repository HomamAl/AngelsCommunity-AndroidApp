package com.example.user.test.exceptions;

public class PasswordConstraintException extends Exception {
    public PasswordConstraintException(String constrained) {
        super(constrained);
    }
}
