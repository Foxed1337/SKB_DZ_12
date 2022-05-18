package ru.zenkov.producer.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@RequestMapping("/activeMq")
public class ProducerController {

    private final JmsTemplate jmsTemplate;

    @GetMapping("/send/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {
        jmsTemplate.convertAndSend("TestQueue", message);
        return new ResponseEntity<>(String.format("Сообщение \"%s\" отправленно в %s",
                message,
                new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())),
                HttpStatus.OK);
    }

    public ProducerController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
