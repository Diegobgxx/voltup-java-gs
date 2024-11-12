package org.voltup.app.infra.exceptions;

public class PlantationNotFoundException extends NotFoundException {
    public PlantationNotFoundException(String message) {
        super(message);
    }
}