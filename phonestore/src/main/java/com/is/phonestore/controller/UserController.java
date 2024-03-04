package com.is.phonestore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.is.phonestore.dto.UserDTO;
import com.is.phonestore.dto.UserLoggedDataDto;
import com.is.phonestore.mapper.UserMapper;
import com.is.phonestore.model.User;
import com.is.phonestore.repository.UserRepository;
import com.is.phonestore.request.*;
import com.is.phonestore.service.ImageService;
import com.is.phonestore.service.UserRatingService;
import com.is.phonestore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@AllArgsConstructor
public class UserController implements UserControllerResource {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserRatingService userRatingService;
    private  final ImageService imageService;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<UserDTO> getUserById(Long id) {
        UserDTO userDTO = userMapper.withUser(userService.getUserById(id)).mapToDto();

        return ResponseEntity.status(200).body(userDTO);
    }

    @Override
    public ResponseEntity<String> addUser(AddUserDto addUserDto) throws Exception {
        User user = userMapper.withAddUserDto(addUserDto).mapToEntity();

        userService.addUser(user);

        return ResponseEntity.status(200).body("Created Successfully");
    }

    @Override
    public ResponseEntity<String> updateUser(String updateUserAdminDTO, Long userId,MultipartFile file) throws Exception {
        try {
            var mapper = new ObjectMapper();
            var updateDto = mapper.readValue(updateUserAdminDTO, UpdateUserAdminDTO.class);

            userService.updateUser(updateDto, userId,file);

        } catch (Exception exception) {

            return ResponseEntity.status(400).body("User does not exist");

        }


        return ResponseEntity.status(200).body("Updated successfully");
    }

    @Override
    public ResponseEntity<String> updateUserRating(Long userId, Float rating, AddUserRatingDTO addUserRatingDTO) {
        try {
            userRatingService.addUserRating(addUserRatingDTO, userId, rating.intValue());
            userService.updateUserRating(userId, rating);

        } catch (Exception exception) {

            return ResponseEntity.status(400).body(exception.toString());

        }


        return ResponseEntity.status(200).body("Rating updated successfully");
    }

    @Override
    public ResponseEntity<String> deleteUserById(Long userId) {
        try {
            userService.deleteUser(userId);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.toString());
        }

        return ResponseEntity.status(200).body("User has been deleted...");
    }

    public  ResponseEntity<String> uploadPhotoForUser(MultipartFile file, Long userId){
        try{
            var imageUrl=imageService.addImage(file);

            userService.updateUserProfilePicture(imageUrl,userId);

            return  ResponseEntity.status(200).body("Added successfully");

        }
        catch (Exception exception){
            return  ResponseEntity.status(400).body(exception.toString());
        }

    }


    @Override
    public ResponseEntity<UserLoggedDataDto> login(LoginDto loginDto) throws Exception {
        var loggingUser = userRepository.checkUserLoginCredentials(loginDto.getUsername(), loginDto.getPassword());
        if (loggingUser != null) {

            var userLoggedDataDto = new UserLoggedDataDto().withUserType(loggingUser.getUserType())
                    .withIsAdmin(loggingUser.getIsAdmin())
                    .withUserType(loggingUser.getUserType())
                    .withUsername(loggingUser.getUsername())
                    .withId(loggingUser.getUserId());

            return ResponseEntity.status(200).body( userLoggedDataDto);

        } else {
            throw new Exception("Incorrect username or password...");

        }
    }
}
