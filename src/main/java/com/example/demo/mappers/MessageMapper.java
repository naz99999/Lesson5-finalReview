package com.example.demo.mappers;

import com.example.demo.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getAllMessages();

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int addMessage(ChatMessage chatMessage);
}
