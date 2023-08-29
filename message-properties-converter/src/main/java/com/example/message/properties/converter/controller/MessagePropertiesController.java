package com.example.message.properties.converter.controller;

import com.example.message.properties.converter.io.MessagePropertiesHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/message/properties")
@RequiredArgsConstructor
public class MessagePropertiesController {
    private final MessagePropertiesHandler messagePropertiesHandler;

    @GetMapping
    public String messageList(Model model) {
        model.addAttribute("koMessage", getMessageOf("message.properties"));
        model.addAttribute("enMessage", getMessageOf("message_en.properties"));
        // @TODO: validate

        return "message/properties/list";
    }

    @PutMapping("/en")
    public String modifyEnglishMessage(@RequestParam Map<String, String> modifiedEnMessage) {
        cleanseMessage(modifiedEnMessage);
        log.info("modifiedEnMessage = {}", modifiedEnMessage);

        messagePropertiesHandler.saveMessages("message_en.properties", modifiedEnMessage);
        return "redirect:/message/properties";
    }

    private void cleanseMessage(Map<String, String> message) {
        message.remove("_method");
    }

    private Map<String, String> getMessageOf(String propertiesFileName) {
        return messagePropertiesHandler.getMessages(propertiesFileName);
    }
}
