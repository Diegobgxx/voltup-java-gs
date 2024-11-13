package org.voltup.app.infra.exceptions;

public class ConnectorTypeNotFoundException extends NotFoundException {
    public ConnectorTypeNotFoundException(String message) {
        super(message);
    }
}
