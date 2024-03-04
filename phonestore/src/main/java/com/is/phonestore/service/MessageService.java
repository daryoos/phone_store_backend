package com.is.phonestore.service;

import com.is.phonestore.model.Message;
import com.is.phonestore.request.AddMessageDTO;
import com.is.phonestore.request.GetChatDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageService {
    Message getMessageById(Long id);

    void addMessage(AddMessageDTO addMessageDTO) throws Exception;

    List<Message> getMessagesByUserId(Long userId,Long otherUserId) throws Exception;
}
