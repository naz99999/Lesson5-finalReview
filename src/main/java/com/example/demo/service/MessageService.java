package com.example.demo.service;

import com.example.demo.model.ChatForm;
import com.example.demo.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private ArrayList<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        this.chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                chatMessage.setMessage(chatForm.getMessageText());
                break;
            case "Shout":
                chatMessage.setMessage(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                chatMessage.setMessage(chatForm.getMessageText().toLowerCase());
                break;
        }
        this.chatMessages.add(chatMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }
}