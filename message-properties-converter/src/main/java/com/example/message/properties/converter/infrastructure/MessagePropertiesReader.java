package com.example.message.properties.converter.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class MessagePropertiesReader {
    public Map<String, String> messagesOf(String propertiesFilePath) {
        // @TODO: 경로 수정
        try(LineIterator lineIterator = FileUtils.lineIterator(new File("message-properties-converter/src/main/resources/" + propertiesFilePath))) {
            Map<String, String> messages = new LinkedHashMap<>();

            while(lineIterator.hasNext()) {
                String readLine = lineIterator.nextLine();
                if(!isMessageProperty(readLine)) continue;

                messages.put(keyOf(readLine), valueOf(readLine));
            }

            log.debug("messages = {}", new ObjectMapper().writeValueAsString(messages));
            return messages;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isMessageProperty(String readLine) {
        return !readLine.startsWith("#") && readLine.contains("=");
    }

    private String keyOf(String line) {
        return line.substring(0, line.indexOf("="));
    }

    private String valueOf(String line) {
        return line.substring(line.indexOf("=") + 1);
    }
}
