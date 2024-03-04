package com.is.phonestore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddMessageDTO {
    private Long senderId;

    private Long receiverId;

    private String text;

    private LocalDateTime dateTime = LocalDateTime.now();
}
