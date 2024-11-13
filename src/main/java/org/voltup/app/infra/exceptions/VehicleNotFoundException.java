package org.voltup.app.infra.exceptions;

public class VehicleNotFoundException extends NotFoundException {
    public VehicleNotFoundException(String message) {
        super(message);
    }
}