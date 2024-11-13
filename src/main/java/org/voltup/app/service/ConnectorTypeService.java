package org.voltup.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voltup.app.domain.ConnectorType;
import org.voltup.app.infra.exceptions.ConnectorTypeNotFoundException;
import org.voltup.app.repository.ConnectorTypeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ConnectorTypeService {

    @Autowired
    private ConnectorTypeRepository repository;

    public ConnectorType create(ConnectorType connectorType) {
        return repository.save(connectorType);
    }

    public ConnectorType findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ConnectorTypeNotFoundException("Connector Type not found"));
    }


    public List<ConnectorType> findAll() {
        return repository.findAll();
    }

    public void delete(String id) {
        ConnectorType connectorType = findById(UUID.fromString(id));
        repository.delete(connectorType);
    }
}
