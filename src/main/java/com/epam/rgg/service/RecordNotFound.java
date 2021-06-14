package com.epam.rgg.service;

public class RecordNotFound extends RuntimeException {

    public RecordNotFound(String message) {
        super(message);
    }
}
