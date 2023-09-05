package com.example.message.properties.converter.infrastructure;

import com.example.message.properties.converter.domain.MessageProperties;
import com.example.message.properties.converter.domain.MessageProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@Component
public class MessagePropertiesWriter {
    public void saveMessages(String propertiesFilePath, MessageProperties messageProperties) {
        // @TODO: 경로 수정
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("message-properties-converter/src/main/resources/" + propertiesFilePath))) {
            messageProperties.getMessageProperties().forEach(messageProperty -> writeMessageProperty(writer, messageProperty));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeMessageProperty(BufferedWriter writer, MessageProperty messageProperty) {
        try {
            writer.write(messageProperty.getKey() + "=" + messageProperty.getEnValue() + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
