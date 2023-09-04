package com.example.message.properties.converter.application;

import com.example.message.properties.converter.infrastructure.MessagePropertiesReader;
import com.example.message.properties.converter.infrastructure.MessagePropertiesWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MessagePropertiesService {
    private final MessagePropertiesReader messagePropertiesReader;
    private final MessagePropertiesWriter messagePropertiesWriter;

    public Map<String, String> messagesOf(String propertiesFilePath) {
        return messagePropertiesReader.messagesOf(propertiesFilePath);
    }

    public void saveMessages(String propertiesFilePath, Map<String, String> messages) {
        messagePropertiesWriter.saveMessages(propertiesFilePath, messages);
    }
}
