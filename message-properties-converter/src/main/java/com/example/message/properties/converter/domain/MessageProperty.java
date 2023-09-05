package com.example.message.properties.converter.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageProperty {
    private String key;
    private String koValue;
    @NotBlank
    private String enValue;
}
