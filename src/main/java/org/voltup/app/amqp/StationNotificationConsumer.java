package org.voltup.app.amqp;

import org.voltup.app.domain.Farm;
import org.voltup.app.domain.User;
import org.voltup.app.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StationNotificationConsumer {

    @Autowired
    private UserService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "station.created")
    public void handleCreatedFarm(Farm farm) {
        User user = userService.findById(farm.getUser().getId());

        rabbitTemplate.convertAndSend("user.notifications." + user.getId(), farm);
    }

}