package com.is.phonestore.service;

import com.is.phonestore.model.User;
import com.is.phonestore.repository.UserRepository;
import com.is.phonestore.request.UpdateUserAdminDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    // TODO: 21.11.2023 Maybe @Autowired needed
    private final UserRepository userRepository;
    private  final ImageService imageService;

    @Override
    public User getUserById(Long id) {
        System.out.println("LOG:\n" + userRepository.findUserByUserId(id) + "\n");
        return userRepository.findUserByUserId(id);
    }

    @Override
    public void addUser(User user) throws Exception {
        try {
            if (userRepository.findByEmailOrUsername(user.getEmail(), user.getUsername()) == null)
                userRepository.save(user);
            else
                throw new Exception("User with the same username or email address already exists...");
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    @Override
    public void updateUser(UpdateUserAdminDTO userAdminDTO, Long userId, MultipartFile file) throws Exception {
        var userData = userRepository.findUserByUserId(userId);
        System.out.println(userAdminDTO.getUsername());
        if (userData != null) {
            if(file!=null) {
                var imageUrl = imageService.addImage(file);
                userData.setProfilePictureUrl(imageUrl);
            }
            userData.setEmail(userAdminDTO.getEmail());
            userData.setPhoneNumber(userAdminDTO.getPhoneNumber());
            userData.setUsername(userAdminDTO.getUsername());

            userRepository.save(userData);

        } else {
            throw new Exception("User does not exist");
        }
    }

    @Override
    public void updateUserRating(Long userID, Float rating) throws Exception {
        var userData = userRepository.findUserByUserId(userID);

        if (userData != null) {
            if (userData.getIsAdmin() == true) {
                throw new Exception("Admin users dont have rating");
            } else {
                userData.setNumberRatings(userData.getNumberRatings() + 1);
                userData.setRating((userData.getRating() + rating) / userData.getNumberRatings());
                userRepository.save(userData);
            }

        } else {
            throw new Exception("User does not exist");
        }


    }

    public  void updateUserProfilePicture(String url,Long userId) throws Exception {
        var userData= userRepository.findUserByUserId(userId);
        if(userData!= null){
            userData.setProfilePictureUrl(url);
            userRepository.save(userData);
        }
        else {
            throw  new Exception("User does not exist");
        }
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        var userData = userRepository.findUserByUserId(userId);

        if (userData != null) {
            userRepository.delete(userData);
        } else {
            throw new Exception("User does not exist...");
        }
    }
}
