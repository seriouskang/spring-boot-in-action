package com.example.message.properties.converter.application;

import com.example.message.properties.converter.domain.MessageProperties;
import com.example.message.properties.converter.domain.MessageProperty;
import com.example.message.properties.converter.infrastructure.MessagePropertiesReader;
import com.example.message.properties.converter.infrastructure.MessagePropertiesWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MessagePropertiesService {
    public static final String MESSAGE_PROPERTIES = "message.properties";
    public static final String MESSAGE_EN_PROPERTIES = "message_en.properties";

    private final MessagePropertiesReader messagePropertiesReader;
    private final MessagePropertiesWriter messagePropertiesWriter;

    public MessageProperties messageProperties() {
        Map<String, String> koMessageProperties = messagePropertiesReader.messagesOf(MESSAGE_PROPERTIES);
        Map<String, String> enMessageProperties = messagePropertiesReader.messagesOf(MESSAGE_EN_PROPERTIES);

        MessageProperties messageProperties = new MessageProperties();
        koMessageProperties.keySet().forEach(key -> {
            messageProperties.addMessageProperty(new MessageProperty(key, koMessageProperties.get(key), enMessageProperties.get(key)));
        });

        return messageProperties;
    }

    public void saveMessages(Map<String, String> messages) {
        messagePropertiesWriter.saveMessages(MESSAGE_EN_PROPERTIES, messages);
    }
}
