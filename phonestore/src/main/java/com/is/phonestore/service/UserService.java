package com.is.phonestore.service;

import com.is.phonestore.model.User;
import com.is.phonestore.request.UpdateUserAdminDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface UserService {

    User getUserById(Long id);

    void addUser(User user) throws Exception;

    void updateUser(UpdateUserAdminDTO userAdminDTO, Long userId, MultipartFile file) throws Exception;

    void deleteUser(Long userId) throws Exception;

    void  updateUserRating(Long userID , Float rating) throws Exception;

    void updateUserProfilePicture(String url,Long userId) throws  Exception;
}
