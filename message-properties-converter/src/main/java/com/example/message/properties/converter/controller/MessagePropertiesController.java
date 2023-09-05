package com.example.message.properties.converter.controller;

import com.example.message.properties.converter.application.MessagePropertiesService;
import com.example.message.properties.converter.domain.MessageProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequestMapping("/message/properties")
@RequiredArgsConstructor
public class MessagePropertiesController {
    private final MessagePropertiesService messagePropertiesService;

    @GetMapping
    public String messageList(Model model) {
        model.addAttribute("messageProperties", messagePropertiesService.messageProperties());

        return "message/properties/list";
    }

    @PutMapping("/en")
    public String modifyEnglishMessage(@ModelAttribute MessageProperties messageProperties, Model model) {
        log.debug("messageProperties = {}", messageProperties);

        messagePropertiesService.validateMessages(messageProperties);
        messagePropertiesService.saveMessages(messageProperties);

        if(messagePropertiesService.containsError(messageProperties)) {
            model.addAttribute("conversionError", "Invalid conversion. Check the error message.");
        }

        model.addAttribute("messageProperties", messageProperties);
        return "message/properties/list";
    }
}
