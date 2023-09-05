package com.example.message.properties.converter.domain;

import com.example.message.properties.converter.domain.exception.MessagePropertyErrorMessage;
import lombok.*;

import static com.example.message.properties.converter.domain.exception.MessagePropertyErrorMessage.*;

@Setter
@Getter
@NoArgsConstructor
public class MessageProperty {
    private String key;
    private String koValue;
    private String enValue;
    private MessagePropertyErrorMessage errorMessage;

    public MessageProperty(String key, String koValue, String enValue) {
        this.key = key;
        this.koValue = koValue;
        this.enValue = enValue;
    }

    public void validateEnglishMessagePropertyValue() {
        if(enValue.isBlank()) {
            errorMessage = EN_PROPERTY_CANNOT_BLANK;
            return;
        }
    }
}
