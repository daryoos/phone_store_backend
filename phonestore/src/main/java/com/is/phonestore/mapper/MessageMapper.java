package com.is.phonestore.mapper;

import com.is.phonestore.dto.MessageDTO;
import com.is.phonestore.model.Message;
import com.is.phonestore.request.AddMessageDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@With
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MessageMapper {
    private Message message;
    private AddMessageDTO addMessageDTO;

    public MessageDTO mapToDTO() {
        return mapMessageToDTO(message);
    }

    public Message mapToEntity() {
        return mapAddMessageDTOToEntity(addMessageDTO);
    }

    private MessageDTO mapMessageToDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setMessageId(message.getMessageId());
        messageDTO.setText(message.getText());
        messageDTO.setDateTime(message.getDateTime());

        return messageDTO;
    }

    private Message mapAddMessageDTOToEntity(AddMessageDTO addMessageDTO) {
        Message message = new Message();

        message.setText(addMessageDTO.getText());
        message.setDateTime(addMessageDTO.getDateTime());

        return message;
    }
}
