package com.is.phonestore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddLoginCredentialsDto {
    private Long loginId;
    private Long userId;
    private String email;
    private String username;
    private String password;
}
