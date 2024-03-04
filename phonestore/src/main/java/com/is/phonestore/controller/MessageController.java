package com.is.phonestore.controller;

import com.is.phonestore.dto.MessageDTO;
import com.is.phonestore.mapper.MessageMapper;
import com.is.phonestore.model.Message;
import com.is.phonestore.request.AddMessageDTO;
import com.is.phonestore.request.GetChatDTO;
import com.is.phonestore.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class MessageController implements MessageControllerResource {

    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @Override
    public ResponseEntity<MessageDTO> getMessageById(Long id) {
        System.out.println("LOG:\n" + messageService.getMessageById(id));
        MessageDTO messageDTO = messageMapper.withMessage(messageService.getMessageById(id)).mapToDTO();

        return ResponseEntity.status(200).body(messageDTO);
    }

    @Override
    public ResponseEntity<String> addMessage(AddMessageDTO addMessageDTO) {
        try {
            messageService.addMessage(addMessageDTO);
        } catch (Exception exception) {
            System.out.println(exception.toString());
            return ResponseEntity.status(400).body(exception.toString());
        }

        return ResponseEntity.status(200).body("Created Successfully");
    }

    @Override
    public ResponseEntity<List<Message>> getMessageByUserId(Long userId,Long otherUserId) throws Exception {
           var chat = messageService.getMessagesByUserId(userId,otherUserId);
           System.out.println(chat);
           return ResponseEntity.status(200).body(chat);



    }


}
