package com.example.message.properties.converter.application;

import com.example.message.properties.converter.domain.MessageProperty;
import com.example.message.properties.converter.infrastructure.MessagePropertiesReader;
import com.example.message.properties.converter.infrastructure.MessagePropertiesWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MessagePropertiesService {
    public static final String MESSAGE_PROPERTIES = "message.properties";
    public static final String MESSAGE_EN_PROPERTIES = "message_en.properties";

    private final MessagePropertiesReader messagePropertiesReader;
    private final MessagePropertiesWriter messagePropertiesWriter;

    public List<MessageProperty> messageProperties() {
        Map<String, String> koMessageProperties = messagePropertiesReader.messagesOf(MESSAGE_PROPERTIES);
        Map<String, String> enMessageProperties = messagePropertiesReader.messagesOf(MESSAGE_EN_PROPERTIES);

        List<MessageProperty> messageProperties = new ArrayList<>();
        koMessageProperties.keySet().forEach(key -> {
            messageProperties.add(new MessageProperty(key, koMessageProperties.get(key), enMessageProperties.get(key)));
        });

        return messageProperties;
    }

    public void saveMessages(Map<String, String> messages) {
        messagePropertiesWriter.saveMessages(MESSAGE_EN_PROPERTIES, messages);
    }
}
