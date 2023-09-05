package com.example.message.properties.converter.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessagePropertyErrorMessage {
    EN_PROPERTY_CANNOT_BLANK("english message property can not blank");

    private final String desc;
}
