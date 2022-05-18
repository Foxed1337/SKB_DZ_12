package ru.zenkov.consumer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.zenkov.consumer.models.MessagesModel;


@Controller
public class ConsumerController {

    private final MessagesModel messagesModel;

    @GetMapping("/get-messages")
    public String getMessages(Model model) {
        model.addAttribute("messages", messagesModel);
        return "message_page";
    }

    public ConsumerController(MessagesModel messagesModel) {
        this.messagesModel = messagesModel;
    }
}
