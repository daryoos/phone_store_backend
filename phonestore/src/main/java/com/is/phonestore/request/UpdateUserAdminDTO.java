package com.is.phonestore.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserAdminDTO {

    private  String email;

    private  String phoneNumber;

    private  String username;


}
