package org.example.exceptions;

public class ValueOutOfBoundsException extends RuntimeException{
    public ValueOutOfBoundsException(String errMessage) {
        super(errMessage);
    }
}
