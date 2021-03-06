package ru.zenkov.consumer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import ru.zenkov.consumer.models.MessagesModel;


@Service
public class ConsumerService {

    private final MessagesModel messagesModel;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @JmsListener(destination = "TestQueue")
    public void receiveMessage(String message) {
        logger.info("Received message: <" + message + ">");
        messagesModel.addMessage(message);
    }

    public ConsumerService(MessagesModel messagesModel) {
        this.messagesModel = messagesModel;
    }
}
