package org.voltup.app.infra.exceptions;

public class StationNotFoundException extends NotFoundException {
    public StationNotFoundException(String message) {
        super(message);
    }
}