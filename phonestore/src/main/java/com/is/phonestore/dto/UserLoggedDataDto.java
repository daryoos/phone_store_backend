package com.is.phonestore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class UserLoggedDataDto {
    Long Id;

    Boolean isAdmin;

    Boolean userType;

    String username;

}
