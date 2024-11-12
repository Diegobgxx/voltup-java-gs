package org.voltup.app.service;

import org.voltup.app.domain.Farm;
import org.voltup.app.domain.User;
import org.voltup.app.infra.exceptions.FarmNotFoundException;
import org.voltup.app.repository.FarmRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FarmService {
    @Autowired
    private FarmRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Farm create(Farm farm) {


        var savedFarm = repository.save(farm);
        rabbitTemplate.convertAndSend("farm.created", savedFarm);

        return savedFarm;
    }

    public Farm findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new FarmNotFoundException("Farm not found"));
    }

    public List<Farm> findAllByUser(UUID userId) {
        User user = userService.findById(userId);
        return repository.findAllByUser(user);
    }


}
