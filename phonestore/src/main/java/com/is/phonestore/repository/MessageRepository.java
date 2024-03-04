package com.is.phonestore.repository;

import com.is.phonestore.model.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAll();

    @Query(value = "select msg from Message msg where msg.messageId = :messageId ")
    Message findMessageByMessageId(@Param("messageId") Long messageId);

    @Query(value = "select msg from Message msg where (msg.senderId = :userId and msg.receiverId = :otherUserId) or (msg.senderId = :otherUserId and msg.receiverId = :userId)")
    List<Message> findMessagesByUserId(@Param("userId") Long userId, @Param("otherUserId") Long otherUserId);
}
