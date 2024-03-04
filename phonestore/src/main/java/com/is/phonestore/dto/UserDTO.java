package com.is.phonestore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long userId;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private Boolean isAdmin;

    private String imageUrl;

    private Float rating;

    private Boolean userType; // 0 - Seller; 1 - Buyers
}
