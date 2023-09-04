package com.example.message.properties.converter.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class MessagePropertiesWriter {
    public void saveMessages(String propertiesFilePath, Map<String, String> messages) {
        // @TODO: 경로 수정
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("message-properties-converter/src/main/resources/" + propertiesFilePath))) {
            for(Map.Entry<String, String> entry: messages.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
