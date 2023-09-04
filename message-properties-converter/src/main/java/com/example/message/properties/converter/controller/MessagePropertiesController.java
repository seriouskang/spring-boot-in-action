package com.example.message.properties.converter.controller;

import com.example.message.properties.converter.application.MessagePropertiesService;
import com.example.message.properties.converter.domain.MessageProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/message/properties")
@RequiredArgsConstructor
public class MessagePropertiesController {
    private final MessagePropertiesService messagePropertiesService;

    @GetMapping
    public String messageList(Model model) {
        model.addAttribute("messageProperties", messageProperties());

        return "message/properties/list";
    }

    @PutMapping("/en")
    public String modifyEnglishMessage(@RequestParam Map<String, String> modifiedEnMessage) {
        cleanseMessage(modifiedEnMessage);
        log.info("modifiedEnMessage = {}", modifiedEnMessage);

        messagePropertiesService.saveMessages(modifiedEnMessage);
        return "redirect:/message/properties";
    }

    private void cleanseMessage(Map<String, String> message) {
        message.remove("_method");
    }

    private List<MessageProperty> messageProperties() {
        return messagePropertiesService.messageProperties();
    }
}
