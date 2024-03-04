package com.is.phonestore.service;

import com.is.phonestore.model.UserRating;
import com.is.phonestore.repository.UserRatingRepository;
import com.is.phonestore.request.AddUserRatingDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserRatingServiceImpl implements UserRatingService {
    private final UserRatingRepository userRatingRepository;
    private  final UserService userService;

    @Override
    public List<UserRating> getUserRatingById(Long id) {
        return userRatingRepository.getUserRating(id);
    }

    @Override
    public void addUserRating(AddUserRatingDTO userRating, Long userId, Integer rating) throws Exception {
            var ratingUser = userService.getUserById(userRating.getUserRatingId());
            var userRated = userService.getUserById(userId);

            if (ratingUser!=null){

                var userRatingData = new UserRating();

                userRatingData.setUserRatingId(userId);
                userRatingData.setReview(userRating.getReview());
                userRatingData.setRatedUser(userRated);
                userRatingData.setRatingUser(ratingUser);
                userRatingData.setRating(rating);
                userRatingRepository.save(userRatingData);

            }
            else {
                throw  new Exception("Rating user does not exist");
            }


    }


}
