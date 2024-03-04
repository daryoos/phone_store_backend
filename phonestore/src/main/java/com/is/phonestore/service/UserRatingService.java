package com.is.phonestore.service;

import com.is.phonestore.model.UserRating;
import com.is.phonestore.request.AddUserRatingDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRatingService {

    List<UserRating> getUserRatingById(Long id);

    void addUserRating(AddUserRatingDTO userRating, Long userId, Integer rating) throws Exception;
}
