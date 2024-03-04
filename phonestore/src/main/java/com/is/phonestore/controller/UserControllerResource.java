package com.is.phonestore.controller;

import com.is.phonestore.dto.UserDTO;
import com.is.phonestore.dto.UserLoggedDataDto;
import com.is.phonestore.request.AddUserDto;
import com.is.phonestore.request.AddUserRatingDTO;
import com.is.phonestore.request.LoginDto;
import com.is.phonestore.request.UpdateUserAdminDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RequestMapping(value = "/v1/users")
public interface UserControllerResource {

    @GetMapping(value = "/getUserById/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable Long id);

    @PostMapping(value = "/register")
    ResponseEntity<String> addUser(@RequestBody AddUserDto addUserDtoU) throws Exception;

    @PutMapping(value = "/updateUser/{userId}")
    ResponseEntity<String> updateUser(@RequestParam("updateUserAdminDto") String updateUserAdminDTO, @PathVariable Long userId,@RequestParam("file") MultipartFile image) throws Exception;

    @PutMapping(value = "/updateUserRating/{userId}/{rating}")
    ResponseEntity<String> updateUserRating(@PathVariable Long userId, @PathVariable Float rating, @RequestBody AddUserRatingDTO addUserRatingDTO);

    @DeleteMapping(value = "/deleteUserById/{userId}")
    ResponseEntity<String> deleteUserById(@PathVariable Long userId);
    @PostMapping(value = "/addImage/{userId}")
    ResponseEntity<String> uploadPhotoForUser(@RequestParam("file") MultipartFile file, @PathVariable Long userId);

    @PostMapping(value = "/login")
    ResponseEntity<UserLoggedDataDto> login(@RequestBody LoginDto loginDto) throws  Exception;

}
