package com.is.phonestore.controller;

import com.is.phonestore.dto.MessageDTO;
import com.is.phonestore.model.Message;
import com.is.phonestore.request.AddMessageDTO;
import com.is.phonestore.request.GetChatDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/v1/messages")
public interface MessageControllerResource {
    @GetMapping(value = "/getMessageById/{id}")
    ResponseEntity<MessageDTO> getMessageById(@PathVariable Long id);

    @PostMapping(value = "/addMessage")
    ResponseEntity<String> addMessage(@RequestBody AddMessageDTO addMessageDTO);

    @GetMapping(value = "/getMessagesByUserId/{userId}/{otherUserId}")
    ResponseEntity<List<Message>> getMessageByUserId(@PathVariable Long userId,@PathVariable Long otherUserId) throws Exception;
}
