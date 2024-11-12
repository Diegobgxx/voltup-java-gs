package org.voltup.app.service;

import org.voltup.app.domain.Strategy;
import org.voltup.app.infra.exceptions.StrategyNotFoundException;
import org.voltup.app.repository.StrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StrategyService {

    @Autowired
    private StrategyRepository repository;

    public Strategy create(Strategy strategy) {
        return repository.save(strategy);
    }

    public Strategy findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new StrategyNotFoundException("Strategy Not Found"));
    }

    public List<Strategy> findAll() {
        return repository.findAll();
    }
}
