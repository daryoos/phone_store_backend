package com.is.phonestore.service;

import com.is.phonestore.model.Message;
import com.is.phonestore.repository.MessageRepository;
import com.is.phonestore.request.AddMessageDTO;
import com.is.phonestore.request.GetChatDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final UserService userService;

    @Override
    public Message getMessageById(Long id) {
        System.out.println("LOG:\n" + messageRepository.findMessageByMessageId(id) + "\n");
        return messageRepository.findMessageByMessageId(id);
    }

    @Override
    public void addMessage(AddMessageDTO message) throws Exception {
        var sender = userService.getUserById(message.getSenderId());
        var receiver = userService.getUserById(message.getReceiverId());

        var messageData = new Message();

        messageData.setSenderId(sender.getUserId());
        messageData.setReceiverId(receiver.getUserId());
        messageData.setText(message.getText());
        messageData.setDateTime(message.getDateTime());

        messageRepository.save(messageData);

        if (sender != null && receiver != null) {

        } else {
            throw new Exception("Chat or User not exist");
        }
    }

    @Override
    public List<Message> getMessagesByUserId(Long userId,Long otherUserId) throws Exception {
        List<Message> chat = messageRepository.findMessagesByUserId(userId, otherUserId);
        if (chat != null) {
            return chat.stream().sorted((o1, o2) -> o1.getDateTime().
                            compareTo(o2.getDateTime())).
                    collect(Collectors.toList());
        } else {
            throw new Exception("Chat between users does not exist");
        }
    }
}
