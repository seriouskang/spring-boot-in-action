package com.example.message.properties.converter.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class MessageProperty {
    private String key;
    private String koValue;
    private String enValue;
    private String errorMessage;

    public MessageProperty(String key, String koValue, String enValue) {
        this.key = key;
        this.koValue = koValue;
        this.enValue = enValue;
    }
}
