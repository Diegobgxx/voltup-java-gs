package org.voltup.app.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voltup.app.domain.Station;
import org.voltup.app.infra.exceptions.StationNotFoundException;
import org.voltup.app.repository.StationRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StationService {
    @Autowired
    private StationRepository repository;

    @Autowired
    private ConnectorTypeService connectorTypeService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Station create(Station station) {


        var savedFarm = repository.save(station);
        rabbitTemplate.convertAndSend("station.created", savedFarm);

        return savedFarm;
    }

    public Station findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new StationNotFoundException("Station not found"));
    }

    public List<Station> findAllByConnectorType(UUID connectorTypeID) {
        var connectorType = connectorTypeService.findById(connectorTypeID);
        return repository.findAllByConnectorTypesContaining(connectorType);
    }

}
