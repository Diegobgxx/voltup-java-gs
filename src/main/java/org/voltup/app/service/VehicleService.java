package org.voltup.app.service;

import org.voltup.app.domain.Vehicle;
import org.voltup.app.infra.exceptions.ConnectorTypeNotFoundException;
import org.voltup.app.infra.exceptions.VehicleNotFoundException;
import org.voltup.app.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    @Autowired
    private UserService userService;

    public Vehicle create(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public Vehicle findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new VehicleNotFoundException("Vehicle Not Found"));
    }

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public List<Vehicle> findByUserId(UUID userId) {
        userService.findById(userId);
        return repository.findAllByUserId(userId);
    }
}
