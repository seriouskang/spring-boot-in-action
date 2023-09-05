package com.example.message.properties.converter.domain;

import lombok.Getter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MessageProperties {
    @Valid
    private List<MessageProperty> messageProperties;

    public MessageProperties() {
        this.messageProperties = new ArrayList<>();
    }

    public void addMessageProperty(MessageProperty messageProperty) {
        messageProperties.add(messageProperty);
    }
}
