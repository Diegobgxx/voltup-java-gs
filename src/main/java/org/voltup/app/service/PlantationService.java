package org.voltup.app.service;

import org.voltup.app.domain.Farm;
import org.voltup.app.infra.exceptions.PlantationNotFoundException;
import org.voltup.app.repository.PlantationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PlantationService {
    @Autowired
    private PlantationRepository repository;

    @Autowired
    private FarmService farmService;

    @Autowired
    private StrategyService strategyService;

    public Plantation create(Plantation plantation) {
        plantation.setDate(LocalDate.now());
        return repository.save(plantation);
    }

    public Plantation findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new PlantationNotFoundException("Plantation not found"));
    }


    public List<Plantation> findAll() {
        return repository.findAll();
    }

    public List<Plantation> findAllByFarm(UUID farmId) {
        Farm farm = farmService.findById(farmId);
        return repository.findAllByFarm(farm);
    }

    public List<Plantation> findAllByStrategy(UUID strategyId) {
        Strategy strategy = strategyService.findById(strategyId);
        return repository.findAllByStrategy(strategy);
    }

    public void delete(String id) {
        Plantation plantation = findById(UUID.fromString(id));
        repository.delete(plantation);
    }
}
