package ru.zenkov.consumer.models;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class MessagesModel {

    private final List<String> messages = new ArrayList<>();

    public void addMessage(String message) {
        messages.add(String.format("Сообщение получено в %s - <%s>",
                new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()),
                message));
    }

    public List<String> getMessages() {
        return messages;
    }
}
