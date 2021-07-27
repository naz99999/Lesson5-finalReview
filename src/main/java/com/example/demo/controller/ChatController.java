package com.example.demo.controller;

import com.example.demo.model.ChatForm;
import com.example.demo.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", messageService.getChatMessages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model) {
        messageService.addMessage(chatForm);
        model.addAttribute("chatMessages", messageService.getChatMessages());
        chatForm.setMessageText("");
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper" };
    }

    @ModelAttribute("bannedWords")
    public String[] bannedWords() { return new String[] {"ban", "fk"}; }

}
