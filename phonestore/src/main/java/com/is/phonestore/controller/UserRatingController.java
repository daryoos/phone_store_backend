package com.is.phonestore.controller;

import com.is.phonestore.dto.UserRatingDTO;
import com.is.phonestore.service.UserRatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class UserRatingController implements UserRatingControllerResource {

    private final UserRatingService userRatingService;

    @Override
    public ResponseEntity<List<UserRatingDTO>> getUserRatingById(Long id) {
        var userData = userRatingService.getUserRatingById(id);
        var userRatingDtoList= new ArrayList<UserRatingDTO>();

        userData.forEach((e)->{
            var userRatingDTO = new UserRatingDTO();
            userRatingDTO.setRating(e.getRating());
            userRatingDTO.setCreatedBy(e.getRatingUser().getUsername());
            userRatingDTO.setProduct(e.getReview());
            userRatingDtoList.add(userRatingDTO);
        });

        return ResponseEntity.status(200).body(userRatingDtoList);
    }

}
