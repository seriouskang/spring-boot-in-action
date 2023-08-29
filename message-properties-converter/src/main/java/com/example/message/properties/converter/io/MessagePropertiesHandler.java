package com.example.message.properties.converter.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class MessagePropertiesHandler {
    public Map<String, String> getMessages(String propertiesFilePath) {
        // @TODO: 경로 수정
        try(LineIterator lineIterator = FileUtils.lineIterator(new File("message-properties-converter/src/main/resources/" + propertiesFilePath))) {
            Map<String, String> messages = new LinkedHashMap<>();

            while(lineIterator.hasNext()) {
                String readLine = lineIterator.nextLine();
                if(!readLine.contains("=")) continue;
                messages.put(keyOf(readLine), valueOf(readLine));
            }

            log.info("messages = {}", new ObjectMapper().writeValueAsString(messages));
            return messages;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    private String keyOf(String line) {
        return line.split("=", -1)[0].trim();
    }

    private String valueOf(String line) {
        return line.split("=", -1)[1].trim();
    }
}
