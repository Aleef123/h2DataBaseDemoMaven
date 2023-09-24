package com.example.h2databasedemomaven.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message,Throwable throwable){super(message,throwable);};
}
