package com.sanjeev.addressbook.exception;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(Long id) {
        super("Contact with id " + id + " not found.");
    }
}
