package com.example.message.properties.converter.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MessageProperty {
    private final String key;
    private final String koValue;
    private final String enValue;
}
