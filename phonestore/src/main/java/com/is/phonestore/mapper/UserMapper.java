package com.is.phonestore.mapper;

import com.is.phonestore.dto.UserDTO;
import com.is.phonestore.model.User;
import com.is.phonestore.request.AddUserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@With
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserMapper {
    private User user;
    private AddUserDto addUserDto;

    public UserDTO mapToDto() {
        return mapUserToDTO(user);
    }

    public User mapToEntity() {
        return mapAddUserDtoToEntity(addUserDto);
    }

    private UserDTO mapUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setIsAdmin(user.getIsAdmin());
        userDTO.setLastName(user.getLastName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setUserType(user.getUserType());
        userDTO.setImageUrl(user.getProfilePictureUrl());
        userDTO.setRating(userDTO.getRating());

        return userDTO;
    }

    private User mapAddUserDtoToEntity(AddUserDto addUserDto) {
        User user = new User();

        // TODO: Nu este nevoie si de set pe userId?
        user.setUsername(addUserDto.getUsername());
        user.setPassword(addUserDto.getPassword());
        user.setEmail(addUserDto.getEmail());
        user.setIsAdmin(addUserDto.getIsAdmin());
        user.setLastName(addUserDto.getLastName());
        user.setFirstName(addUserDto.getFirstName());
        user.setPhoneNumber(addUserDto.getPhoneNumber());
        user.setUserType(addUserDto.getUserType());

        return user;
    }
}
