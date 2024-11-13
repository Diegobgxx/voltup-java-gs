package org.voltup.app.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.voltup.app.domain.Station;
import org.voltup.app.service.UserService;

@Component
public class StationNotificationConsumer {

    @Autowired
    private UserService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "station.created")
    public void handleCreatedFarm(Station station) {
        rabbitTemplate.convertAndSend("user.notifications.newStation", station);
    }

}